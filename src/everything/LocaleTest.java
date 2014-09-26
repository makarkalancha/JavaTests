package everything;

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
        Locale.setDefault(en);
        System.out.println(defaultLocale.getDisplayName());
        System.out.println(en.getDisplayName());
    }
}
