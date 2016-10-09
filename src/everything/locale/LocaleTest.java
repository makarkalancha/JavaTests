package everything.locale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * User: Makar Kalancha
 * Date: 12/12/13
 * Time: 1:56 PM
 */
public class LocaleTest {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        Locale en = new Locale("en","US");
        Locale ja = new Locale("ja","JA");
        Locale.setDefault(ja);
        System.out.println(defaultLocale.getDisplayName());
        System.out.println(en.getDisplayName());
        System.out.println(en.getISO3Language());
        System.out.println(en.getLanguage());
        System.out.println(ja.getLanguage());

        String CALENDAR_MONTH_FORMAT_PATTERN = "MMMM, yyyy";
        DateTimeFormatter CALENDAR_MONTH_FORMAT_DTF = DateTimeFormatter.ofPattern(CALENDAR_MONTH_FORMAT_PATTERN, Locale.getDefault());
        LocalDate firstDayOfMonthDate = LocalDate.now();
        System.out.println(firstDayOfMonthDate.format(CALENDAR_MONTH_FORMAT_DTF));
    }
}
