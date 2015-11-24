package everything.numbertest;

/**
 * Created by mcalancea on 2015-09-24.
 */
public class WrapperVsPrimitive {

    public static void main(String[] args) {
        Long long1 = null;
        long long2 = 100L;
        Long long3 = new Long(100);
//        System.out.println("null == 100L:"+(long1 == long2));//NPE
//        System.out.println("null == new Long(100L):"+(long1 == long3));

//        System.out.println(long1.toString());//NPE

        Double thousand23 = 23_000.0;
        System.out.println(thousand23 / 1_000);
    }

}
