package com.everything.reflection;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 13/06/14
 * Time: 3:16 PM
 */
public class ReflectionCleanString {
    public static void main(String[] args) {
        Device dev = new Device();
        initializeDevice(dev);
        System.out.println(dev);
        Class clazz = dev.getClass();
        Field[] fields = clazz.getFields();
        for(int i = 0 ; i < fields.length ; i++) {
            Field field = fields[i];
            System.out.print(field.getName());
            System.out.print(" - ");
            System.out.print(field.getType().getSimpleName());
            if(field.getType().getSimpleName().equalsIgnoreCase("String")) {
                try{
                String value = (String)field.get(dev);
                System.out.print(" - "+value);
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }else{
                System.out.print(" - nothing");
            }
            System.out.println();
        }
    }

    public static void initializeDevice(Device dev) {
        dev.udid = "6d957bbd0b959c208e66a52281bcc30c";
        dev.name = "Other";
        dev.family = "Desktop";
        dev.osVersion = "ActivTouch Mobile";
//        dev.screenSize = "null";
//        dev.userAgent = "null";
//        dev.userAgent = null;
        dev.version = "HUAQIN50_COSMOS_11B_HW (MRE\\2.5.00(2700) resolution\\320480 chipset\\MT6250 touch\\1 tpannel\\1 camera\\0 gsensor\\0 keyboard\\normal) ZP868AB_074A_V8_0_1 Release/2013.01.10 WAP Browser/MAUI (HTTP PGDL; HTTPS) Profile/  Q03C1-2.40 en-US";
        try{
            dev.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-01-02 00:00:00");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public static class Device
    {
        public String udid;
        public String name;
        public String family;
        public String osVersion;
        public String screenSize;
        public String userAgent;
        public String version;
        public Date date;

        @Override
        public String toString() {
            return "Device{" +
                    "udid='" + udid + '\'' +
                    ", name='" + name + '\'' +
                    ", family='" + family + '\'' +
                    ", osVersion='" + osVersion + '\'' +
                    ", screenSize='" + screenSize + '\'' +
                    ", userAgent='" + userAgent + '\'' +
                    ", version='" + version + '\'' +
                    ", date=" + date +
                    '}';
        }
    }
}
