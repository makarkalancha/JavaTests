package com.everything.parsers.targets;

import com.everything.parsers.gnydm.Session;
import com.everything.parsers.gnydm.Speaker;
import com.everything.parsers.gnydm.Track;
import com.everything.strings.StringUtil;
import com.everything.utils.fileUtils.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 23/09/14
 * Time: 2:00 PM
 */
//http://www.gnydm.com/list-courses-2014.aspx
public class GnydmSessions {
    public static void main(String[] args) {
        String filePath = "D:\\Tasks\\067__gnydm2014_sd\\2-data\\20140923\\sessions from speakers.html";
        StringBuilder htmlString = new StringBuilder();
        try{
            FileUtils.readFileIntoString(filePath,htmlString);
//            System.out.println(htmlString);
        }catch(IOException e){
            e.printStackTrace();
        }

        Document doc = Jsoup.parseBodyFragment(htmlString.toString());
        Elements tables = doc.getElementsByTag("table");
//        System.out.println(tables);
//        System.out.println(tables.size());
        List<Session> sessions = new ArrayList<>();
        mapElementToSession(tables, sessions);


        Set<Speaker> speakers = getAllSpeakers(sessions);
        int speakerIter = 1;
        for(Speaker speaker : speakers){
            speaker.setID("SP"+speakerIter);
            System.out.println(speaker + "\t" +
                    speaker.getFirstName() + "\t" +
                    speaker.getLastName()
            );
            speakerIter++;
        }
        System.out.println("================================================================");
        Set<Track> tracks = getAllTracks(sessions);
        int trackIter = 1;
        for(Track track : tracks){
            track.setID("TR"+trackIter);
            System.out.println(track+"\t"+
                    track.getName()
            );

            trackIter++;
        }
        System.out.println("================================================================");
        //        System.out.println(Arrays.toString(sessions.toArray()));
        for(Session session : sessions){
            System.out.println(session);
        }

    }

    private static Set<Track> getAllTracks(Collection<Session> sessions) {
        Set<Track> tracks = new HashSet<>();
        for(Session session : sessions) {
            tracks.add(session.getCourseTopic());
        }
        return tracks;
    }

    private static Set<Speaker> getAllSpeakers(Collection<Session> sessions) {
        Set<Speaker> speakers = new HashSet<>();
        for(Session session : sessions) {
            speakers.addAll(session.getSpeakers());
        }
        return speakers;
    }

    private static void getValue(Element elem, String rowHeader, Session session){
        Elements rows = elem.select("tr:has(td:contains("+rowHeader+"))");
        if(rows.size()==1 && rows.select("td").size() == 2) {
            try {
                session.getClass().getField(StringUtil.convertStringToCamelCase(rowHeader)).set(session, rows.select("td:nth-child(2)").text());
            }catch (NoSuchFieldException | IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    public static void mapElementToSession(Elements elements, Collection<Session> sessionCollection) {
        Iterator<Element> iterator = elements.iterator();
        while(iterator.hasNext()) {
            Session session = new Session();
            Element table = iterator.next();
            ///////////CourseDate
            getValue(table,"Course Date",session);
            ///////////CourseNumber
            getValue(table,"Course Number",session);
            ///////////CourseTitle
            getValue(table,"Course Title",session);
            ///////////CourseTopic
            getValue(table,"Course Topic",session);
            ///////////Speakers
            getValue(table,"Speaker(s)",session);
            ///////////SessionType
            getValue(table,"Session Type",session);
            ///////////CourseType
            getValue(table,"Course Type",session);
            ///////////TuitionDentist
            getValue(table,"Tuition (Dentist)",session);
            ///////////TuitionAux
            getValue(table,"Tuition (Aux)",session);
            ///////////CourseTime
            getValue(table,"Course Time",session);
            ///////////Room
            getValue(table,"Room",session);
            

            sessionCollection.add(session);
//            break;

        }

    }

}
