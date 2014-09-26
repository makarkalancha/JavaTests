package com.test.everything.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 28/08/14
 * Time: 10:28 AM
 */
public class MapTesting {
    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("exh1", true);
        map.put("exh2", true);
        map.put("exh3", false);
        map.put("exh4", true);
        map.put("exh12", true);
        Boolean get1 = map.get("exh2");
        Boolean get2 = map.get("exh3");
        Boolean get3 = map.get("exh23");
        System.out.println("get1:"+get1);
        System.out.println("get2:"+get2);
        System.out.println("get3:"+get3);

    }
}
