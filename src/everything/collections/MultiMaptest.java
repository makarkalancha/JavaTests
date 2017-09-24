package everything.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Makar Kalancha
 * Date: 02 Aug 2017
 * Time: 16:52
 */
public class MultiMapTest {
    public static void main(String[] args) {
        Multimap<String, String> stringStringMultimap = ArrayListMultimap.create();
        stringStringMultimap.put("fish", "1");
        stringStringMultimap.put("fish", "2");
        stringStringMultimap.put("fish", "3");
        stringStringMultimap.put("cat", "100.5");

        System.out.println(stringStringMultimap);

        Multimap<String, BigDecimal> stringBigDecimalMultimap = ArrayListMultimap.create();

        for(Map.Entry<String, String> entry : stringStringMultimap.entries()){
            System.out.println(entry.getKey() + ": "+entry.getValue());
            stringBigDecimalMultimap.put(entry.getKey(), new BigDecimal(entry.getValue()));
        }

        System.out.println(stringBigDecimalMultimap);

        for(String key : stringStringMultimap.keySet()){
            System.out.println("-"+key);
            for(String value : stringStringMultimap.get(key)){
                System.out.println("----"+value);
            }
        }
    }
}
