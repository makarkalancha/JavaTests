package com.everything.parsers.gnydm;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 23/09/14
 * Time: 3:59 PM
 */
public class Speaker {
    private String firstName;
    private String lastName;
    private String ID;

    private static Map<String,Speaker> _speakerCodeToSpeakerObj = new HashMap<>();

    private Speaker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println(">>>" + (count++)+"; map size: "+_trackNameToTrackObj.size());
    }

    public static String createSpeakerCode(String firstName, String lastName){
        return firstName+lastName;
    }

    public static Speaker createSpeaker(String firstName, String lastName) {
        String speakerCode = createSpeakerCode(firstName, lastName);
        Speaker instance = _speakerCodeToSpeakerObj.get(speakerCode);
        if(instance == null) {
            instance = new Speaker(firstName, lastName);
            _speakerCodeToSpeakerObj.put(speakerCode, instance);
        }
        return instance;
    }

    public void setID(String string){
        this.ID = string;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return (ID == null) ? Integer.toString(hashCode()) : ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speaker speaker = (Speaker) o;

        if (firstName != null ? !firstName.equals(speaker.firstName) : speaker.firstName != null) return false;
        if (lastName != null ? !lastName.equals(speaker.lastName) : speaker.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
