package com.everything.parsers.gnydm;

import com.everything.strings.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 23/09/14
 * Time: 2:01 PM
 */
public class Session {
    private final SimpleDateFormat sdf = new SimpleDateFormat("EEEE',' MMMM d',' yyyy");//Friday, November 28, 2014
    public String CourseDate;
    public String CourseNumber;
    public String CourseTitle;
    public String CourseTopic;
    public String Speakers;
    public String SessionType;
    public String CourseType;
    public String TuitionDentist;
    public String TuitionAux;
    public String CourseTime;
    public String Room;

    private Track _track;

    @Override
    public String toString() {
//        return "Session{" +
//                "CourseDate='" + getDate() + '\'' +
//                ", CourseNumber='" + CourseNumber + '\'' +
//                ", CourseTitle='" + CourseTitle + '\'' +
//                ", CourseTopic='" + CourseTopic + '\'' +
//                ", Speakers='" + Arrays.toString(getSpeakers().toArray()) + '\'' +
//                ", SessionType='" + SessionType + '\'' +
//                ", CourseType='" + CourseType + '\'' +
//                ", TuitionDentist='" + TuitionDentist + '\'' +
//                ", TuitionAux='" + TuitionAux + '\'' +
//                ", CourseTime='" + CourseTime + '\'' +
//                '}';
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        String[] startEndTime = CourseTime.split("-");
        String speakersString = StringUtil.mergeObjects(getSpeakers(), ",");

        return CourseNumber +"\t"+
                CourseTitle +"\t"+
                Room +"\t"+
                cal.get(Calendar.YEAR) +"\t"+
                (cal.get(Calendar.MONTH) +1)+"\t"+
                cal.get(Calendar.DAY_OF_MONTH) +"\t"+
                startEndTime[0].trim() +"\t"+
                ((startEndTime.length==2) ? startEndTime[1].trim() : "") +"\t"+
                speakersString +"\t"+
                getCourseTopic().toString() +"\t"
                ;
    }

    public Date getDate() {
        try{
            return sdf.parse(CourseDate);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public Collection<Speaker> getSpeakers() {
        List<Speaker> speakers = new ArrayList<>();
        if(!StringUtil.isEmpty(Speakers)){
            String[] speakersArray = Speakers.split("/");
            for (String speaker : speakersArray){
                String[] speakerName = speaker.split(",");
                Speaker speakerObj = Speaker.createSpeaker(speakerName[1].trim(),speakerName[0].trim());
                speakers.add(speakerObj);
            }
        }
        return speakers;
    }

    public Track getCourseTopic(){
        if(_track == null) {
            _track = Track.createTrack(CourseTopic);
        }
        return _track;
    }
    
}
