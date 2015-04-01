package everything.booleantest;

/**
 * Created by mcalancea on 2015-04-01.
 */
public class BooleanMain {
    public static void main(String[] args) {
        Boolean first = false;
        Boolean second = null;
        Boolean third = null;
        boolean result1 = first || second && third;
        System.out.println(result1);
    }
}
