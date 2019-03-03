package com.everything.locale;

import java.text.DateFormat;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

/**
 * User: Makar Kalancha
 * Date: 27/02/2016
 * Time: 19:22
 */
public class LocaleDemo {

    //vm option: -Djava.ext.dirs=lib
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.locale.providers"));
        System.setProperty("java.locale.providers", "HOST,SPI,JRE");
//        System.setProperty("java.locale.providers", "HOST");
        System.out.println(System.getProperty("java.locale.providers"));


////        Locale myLocale = new Locale.Builder().setLanguageTag("me-ME-u-fw-mon").build();
////        Locale myLocale = new Locale("me","ME");
//        Locale myLocale = new Locale("me_ME");
////        Locale myLocale = new Locale.Builder().setLanguageTag("me-ME-u-ca-iso8601").build();
////        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.everything.locale.CustomLocale", myLocale);
////        Locale myLocale = new Locale("ru");
////        CalendarData calendarDataProvider = CalendarDataProvider.get
////        Locale myLocale = new Locale("en", "US", "ru");
////        System.out.println(new CalendarDataProviderImp().getFirstDayOfWeek(myLocale));
//        Locale.setDefault(myLocale);
        System.out.println(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek());

//        WeekFields.of(DayOfWeek.MONDAY, 1);
//        System.out.println(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek());
//        System.out.println("getUnicodeLocaleKeys:");
//        Set<String> strings1 = Locale.getDefault().getUnicodeLocaleKeys();
//        for(String string : strings1){
//            System.out.println(string);
//        }
//        System.out.println("getUnicodeLocaleAttributes:");
//        Set<String> strings2 = Locale.getDefault().getUnicodeLocaleAttributes();
//        for(String string : strings2){
//            System.out.println(string);
//        }


        Date now = new Date();
        DateFormat defaultFormat = DateFormat.getDateTimeInstance();
        String     defaultString = defaultFormat.format(now);
        System.out.println ("Default date format: " + defaultString);
        DateFormat newAtlantisFormat = DateFormat.getDateTimeInstance (
                DateFormat.FULL,
                DateFormat.FULL,
                new Locale ("en", "NA")
        );
        String strNewAtlantisDate = newAtlantisFormat.format(now);
        System.out.println ("NewAtlantis date format: " + strNewAtlantisDate);



    }
}
