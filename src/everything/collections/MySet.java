package everything.collections;

import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 06/06/14
 * Time: 10:43 AM
 */
public class MySet {
    public static void main(String[] args) {
        Set<String> a = new TreeSet<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");

        Set<String> b = new TreeSet<>();
        b.add("2");
        b.add("3");
        b.add("5");
        b.add("6");

        System.out.println("a:"+Arrays.toString(a.toArray()));
        System.out.println("b:"+Arrays.toString(b.toArray()));

        Set<String> union = new TreeSet<>(a);
        union.addAll(b);
        System.out.println("union:"+Arrays.toString(union.toArray()));
        Set<String> diff = new TreeSet<>(union);
        diff.removeAll(b);
        System.out.println("diff:"+Arrays.toString(diff.toArray()));


        System.out.println("\nsymmetric diff");
        Set<String> tmp = new TreeSet<>(a);
        tmp.retainAll(b);
        System.out.println("tmp:" + Arrays.toString(tmp.toArray()));
        union.removeAll(tmp);
        System.out.println("union:"+Arrays.toString(union.toArray()));





    }

}
