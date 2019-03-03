package com.everything.references;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mcalancea on 2015-04-14.
 */
//-Xms1024k -Xmx2048k
public class WeakReferenceTest {
    private WeakReference<Map<Integer,String>> myMap;

    public static void main(String[] args) throws InterruptedException{
        new WeakReferenceTest().doFunction();
    }

    private void doFunction() throws InterruptedException{
        Map<Integer, String> map = new HashMap<>();
        myMap = new WeakReference<Map<Integer, String>>(map);

        map = null;
        int i = 0;
        while(true){
            Thread.sleep(10);
            if(myMap != null && myMap.get() != null) {
                myMap.get().put(++i, "test" + i);
                System.out.println(i+") I'm still working!!!");
            } else{
                System.out.println(i+") ******I'm free******");
                System.out.println("myMap != null:"+(myMap != null)+ "; myMap.get() != null:"+(myMap.get() != null));
                System.exit(0);
            }
        }
    }
}
