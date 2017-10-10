package com.everything.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 09/12/13
 * Time: 11:42 AM
 */
public class Reflection {
    public static final boolean FREE_CONFERENCE = true;

    public static void main(String[] args) {
        GePlanner planner = createTestObj();
        try{
            String xml = createXml(planner);
            System.out.println(xml);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static GePlanner createTestObj(){
        GePlanner planner = new GePlanner();
        planner.user_id = "100";
        GePlanner.GePlannerProduct prod1 = planner.new GePlannerProduct();
        prod1.id = "1201";
        prod1.user_id = "1301";
        prod1.product_id = "1401";
        GePlanner.GePlannerProduct prod2 = planner.new GePlannerProduct();
        prod2.id = "2201";
        prod2.user_id = "2301";
        prod2.product_id = "2401";
        planner.product_elements.add(prod1);
        planner.product_elements.add(prod2);
        return planner;
    }

    public static String createXml(GePlanner planner) throws IllegalAccessException{
        StringBuilder result = new StringBuilder();
        result.append("<user_id xsi:type=\"xsd:string\">");
        result.append(planner.user_id);
        result.append("</user_id>\n");
        result.append(createInnerXml(planner.product_elements));

        return result.toString();
    }

    public static <T> String createInnerXml(List<T> obj) throws IllegalAccessException{
        StringBuilder result = new StringBuilder();
        for(T clazz : obj){
            result.append("\t<item xsi:type=\"tns:");
            result.append(clazz.getClass().getSimpleName());
            result.append("\">\n");
            Field[] fields = clazz.getClass().getDeclaredFields();
            System.out.println(fields.length);
            for(Field f : fields){
                if(!f.getName().equalsIgnoreCase("this$0")){
                    result.append("\t\t<");
                    result.append(f.getName());
                    result.append(" xsi:type=\"xsd:string\">");
                        result.append(f.get(clazz));
                    result.append("</");
                    result.append(f.getName());
                    result.append(">\n");
                }
            }
            result.append("\t</item>\n");
        }
        return result.toString();
    }

}

class GePlanner {
    public String user_id;
    public List<GePlannerProduct> product_elements;
    public GePlanner(){
        product_elements = new ArrayList<GePlannerProduct>();
    }
    public class GePlannerProduct{
        public String user_id;
        public String id;
        public String product_id;
    }
}


