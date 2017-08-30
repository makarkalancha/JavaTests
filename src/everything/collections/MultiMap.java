package everything.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Makar Kalancha
 * Date: 22 Aug 2017
 * Time: 10:32
 */
public class MultiMap {
    public static void main(String[] args) {
        List<Object[]> rows = new ArrayList<>();
        rows.add(new Object[]{123L, "1,3,5"});
        rows.add(new Object[]{456L, "10,30,50"});

//        Multimap<Long, Long> result = rows.stream()
//                .collect(
//                        ArrayListMultimap::create,
//                        (map, obj) -> map.putA((Long) obj[0],
//                                Arrays.asList(((String)obj[1]).split(",")).stream()
//                                    .map(str -> Long.parseLong(str))
//                                    .collect(Collectors.toList())
//                                ,
//                        ArrayListMultimap::putAll
//                );
//        System.out.println(result);

        Multimap<Long, Long> result = ArrayListMultimap.create();
        for(Object[] objectArray : rows){
            List<Long> destinationIds = Arrays.asList(((String)objectArray[1]).split(",")).stream()
                    .map(str -> Long.parseLong(str))
                    .collect(Collectors.toList());
            result.putAll(((Long) objectArray[0]).longValue(), destinationIds);
        }
        System.out.println(result);

        System.out.println(TimeUnit.MILLISECONDS.toMinutes(3600000L));
    }
}