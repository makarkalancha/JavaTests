package everything.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 28/08/14
 * Time: 10:28 AM
 */
public class MapTesting {
    public static void main(String[] args) {
//        Map<String, Boolean> map = new HashMap<String, Boolean>();
//        map.put("exh1", true);
//        map.put("exh2", true);
//        map.put("exh3", false);
//        map.put("exh4", true);
//        map.put("exh12", true);
//        Boolean get1 = map.get("exh2");
//        Boolean get2 = map.get("exh3");
//        Boolean get3 = map.get("exh23");
////        System.out.println("get1:"+get1);
////        System.out.println("get2:"+get2);
////        System.out.println("get3:"+get3);
//
//
//        Map<String, Integer> mapHeader = new HashMap<String, Integer>();
//        mapHeader.put("exh1", 0);
//        mapHeader.put("exh2", 1);
//        mapHeader.put("exh3", 2);
//        mapHeader.put("exh4", 3);
//        mapHeader.put("exh12", 4);
//        List<String> rowList = new ArrayList<>();
//        rowList.add("elem1");
//        rowList.add("elem2");
//        rowList.add("elem3");
//        rowList.add("elem4");
//        rowList.add("elem12");
//        Integer getInt2 = mapHeader.get("exh2");
//        Integer getInt23 = mapHeader.get("exh23");
//        System.out.println("get2:"+getInt2);
//        System.out.println("get23:"+getInt23);
//        System.out.println("get3:"+rowList.get(mapHeader.get("exh3")));
//
//        Integer getInt33 = mapHeader.get("exh33");
//        System.out.println("get33:"+rowList.get(getInt33));


        Map<Integer, Wrapper> mapIntegerToString = new HashMap<>();
        Wrapper a = new Wrapper(0, "exh0");
        Wrapper b = new Wrapper(1, "exh1");
        Wrapper c = new Wrapper(2, "exh2");
        Wrapper d = new Wrapper(3, "exh3");

        mapIntegerToString.put(a.getInteger(), a);
        mapIntegerToString.put(b.getInteger(), b);
        mapIntegerToString.put(c.getInteger(), c);
        mapIntegerToString.put(d.getInteger(), d);
        System.out.println(mapIntegerToString);

        c.setInteger(22);
        System.out.println(mapIntegerToString);
    }

    private static class Wrapper{
        private Integer integer;
        private String string;

        public Wrapper(Integer integer, String string) {
            this.integer = integer;
            this.string = string;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return "Wrapper{" +
                    "integer=" + integer +
                    ", string='" + string + '\'' +
                    '}';
        }
    }
}
