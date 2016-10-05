package everything.java8tests.lambda;

import ch.lambdaj.Lambda;
import ch.lambdaj.function.convert.Converter;

import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 17/02/14
 * Time: 11:51 AM
 */
public class LambdaTest {

    public static void main(String[] args) {
        Set<String> categories = new HashSet<String>();
        categories.add("first");
        categories.add("second");
        categories.add("third");
        categories.add("forth");


//        LambdaDemo lambda = new LambdaDemo();
        List<String> prefixedCategories = Lambda.convert(categories, new PrefixCategorie());
        System.out.println(Arrays.toString(prefixedCategories.toArray()));
    }

    static class PrefixCategorie implements Converter<String,String>{
        @Override
        public String convert(String s) {
            return "_vita_"+s;
        }
    }
}
