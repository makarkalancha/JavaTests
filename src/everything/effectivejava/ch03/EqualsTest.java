package everything.effectivejava.ch03;

/**
 * Created by mcalancea on 2015-04-17.
 */
public class EqualsTest {
    public static void main(String[] args) {
        CaseInsensitiveString caseInsensitiveString1 = new CaseInsensitiveString("A");
        CaseInsensitiveString caseInsensitiveString2 = new CaseInsensitiveString("a");
        String string3 = "a";
        System.out.println("======================================================");
        System.out.println(caseInsensitiveString1.equals(caseInsensitiveString2));
        System.out.println(caseInsensitiveString2.equals(caseInsensitiveString1));
        System.out.println("======================================================");
        System.out.println(caseInsensitiveString1.equals(string3));
        System.out.println(string3.equals(caseInsensitiveString1));

    }
}
