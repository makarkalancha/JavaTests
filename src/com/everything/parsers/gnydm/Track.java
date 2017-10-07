package com.everything.parsers.gnydm;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 23/09/14
 * Time: 4:31 PM
 */
public class Track {
//    private static int count = 0;
//    public  Track() {
//        System.out.println(">>>" + (count++));
//    }

    private static Map<String,Track> _trackNameToTrackObj = new HashMap<>();

    private String name;
    private String ID;

    private Track(String name) {
        this.name = name;
//        System.out.println(">>>" + (count++)+"; map size: "+_trackNameToTrackObj.size());
    }

    public static Track createTrack(String name) {
        Track instance = _trackNameToTrackObj.get(name);
        if(instance == null) {
            instance = new Track(name);
            _trackNameToTrackObj.put(name, instance);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setID(String string){
        this.ID = string;
    }

    @Override
    public String toString() {
        return (ID == null) ? Integer.toString(hashCode()) : ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (name != null ? !name.equals(track.name) : track.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
