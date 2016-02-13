package everything.collections;

import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 06/11/13
 * Time: 4:40 PM
 */
public class MyMap {
    public static void main(String [] args){
        Map<String, MyMapClass> m = new HashMap<String, MyMapClass>();
        Set<MyMapClass> mSet = new HashSet<MyMapClass>();
        MyMapClass a1 = new MyMapClass();
        MyMapClass ab1 = new MyMapSubclass(10);
        MyMapSubclass b1 = new MyMapSubclass(15);

        m.put("1",a1);
        m.put("2",ab1);
        m.put("3",b1);

        mSet.add(a1);
        mSet.add(ab1);
        mSet.add(b1);

//        Map<String, ? extends everything.collections.MyMapClass> map = new HashMap<>();
////        for(Map.Entry<String, everything.collections.MyMapClass> mmc : m.entrySet()) {
//////            everything.collections.MyMapClass a1 = new everything.collections.MyMapClass();
//////            map.put("100", a1);
////            map.put(mmc.getKey(), mmc.getValue());
////        }
//        Iterator<? extends everything.collections.MyMapClass> iterMyClass = mSet.iterator();
////        Iterator<? extends everything.collections.MyMapClass> iterMyClass = m.iterator();
//        while(iterMyClass.hasNext()) {
//            map.put("some",iterMyClass);
//        }
    }
}

class MyMapClass{
    int a;
    MyMapClass(){
        this(5);
    }
    MyMapClass(int a){
        this.a=a;
    }
}

class MyMapSubclass extends MyMapClass{
    int b;
    MyMapSubclass(int b){
        this.b=b;
    }
}
