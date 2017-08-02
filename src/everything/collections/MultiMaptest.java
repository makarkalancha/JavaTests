package everything.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

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
        stringStringMultimap.put("cat", "one");

        System.out.println(stringStringMultimap);

        for(Map.Entry<String, String> entry : stringStringMultimap.entries()){
            System.out.println(entry.getKey() + ": "+entry.getValue());
        }

        for(String key : stringStringMultimap.keySet()){
            System.out.println("-"+key);
            for(String value : stringStringMultimap.get(key)){
                System.out.println("----"+value);
            }
        }
    }
}
