package everything.locale;

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
        Locale.setDefault(en);
        System.out.println(defaultLocale.getDisplayName());
        System.out.println(en.getDisplayName());
        System.out.println(en.getISO3Language());
        System.out.println(en.getDisplayLanguage(en));
        System.out.println(ja.getDisplayLanguage(ja));
    }
}
