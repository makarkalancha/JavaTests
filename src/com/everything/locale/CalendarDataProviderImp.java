package com.everything.locale;

import java.util.Locale;
import java.util.spi.CalendarDataProvider;

/**
 * User: Makar Kalancha
 * Date: 27/02/2016
 * Time: 19:48
 */
public class CalendarDataProviderImp extends CalendarDataProvider {
    private Locale myLocale = new Locale("me_ME");
    @Override
    public int getFirstDayOfWeek(Locale locale) {
        if(locale.equals(myLocale)) {
            return 2;
        }
        return 1;
    }

    @Override
    public int getMinimalDaysInFirstWeek(Locale locale) {
        return 1;
    }

    @Override
    public Locale[] getAvailableLocales() {
//        return new Locale[]{new Locale.Builder().setLanguageTag("me-ME-u-fw-mon").build()};
        return new Locale[]{myLocale};

    }
}
