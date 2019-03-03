package com.everything.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 07/01/14
 * Time: 11:19 AM
 */
public class Reflection_v1 {
    public static void main(String[] args) {
        Context ctx = new Context();

        MySoapClient client = new MySoapClient();
//        System.out.println(client.getAdditionalBoothInformation().getType());
//        System.out.println(client.getFloorplanData().getType());

//        ctx.putData("a",new com.everything.reflection.MyResponseA());
//        Object o = ctx.getData("a");
////        System.out.println(((com.everything.reflection.MyResponseA)o).getType());
//        System.out.println(o.getClass().getSimpleName());

//        Object obj1 = getResponse(client,ctx,"getFloorplanData");
//        System.out.println(obj1.getClass().getSimpleName());
//        System.out.println(((com.everything.reflection.MyResponseA)obj1).aSt);
//
//        Object obj2 = getResponse(client,ctx,"getFloorplanData");
//        System.out.println(obj2.getClass().getSimpleName());
//        System.out.println(((com.everything.reflection.MyResponseA)obj2).aSt);

        SimplePojo pojo = new SimplePojo();
        Field[] fields = pojo.getClass().getDeclaredFields();
        String[] strings = Arrays.copyOf(fields,fields.length,String[].class);
        for(String s : strings){
            System.out.println(s);
        }
    }

    public static Object getResponse(MySoapClient client, Context ctx, String methodName) {
        String key = client.getEventId() + "_" + methodName;
        Object response = ctx.getData(key);
        if(response == null){
            System.out.println("in if");
            try {
                Method method = client.getClass().getMethod(methodName);
                ctx.putData(key, method.invoke(client));
                response = ctx.getData(key);
            }catch(NoSuchMethodException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("in else");
        }

        return response;
    }
}

class Context{
    Map<String, Object> map = new HashMap<String, Object>();
    public Object getData(String key){
        return map.get(key);
    }

    public void putData(String key, Object obj) {
        map.put(key, obj);
    }
}

class MyResponse{
    MyResponse(){}
    public String getType() {
        return this.getClass().getSimpleName();
    }
}

class MyResponseA extends MyResponse{
    public String aSt = "a";
    MyResponseA(){}
}

class MyResponseB extends MyResponse{
    public String bSt = "b";
    MyResponseB(){}
}

class MySoapClient{
    public MyResponseA getFloorplanData (){
        return new MyResponseA();
    }

    public MyResponseB getAdditionalBoothInformation (){
        return new MyResponseB();
    }

    public String getEventId() {
        return "470";
    }
}

class SimplePojo
{
    public String ExhID;
    public String ExhName;
    public String Div;
    public String Alpha;
    public String Password;
    public String AdvInd;
    public String Package;
    public String Address1;
    public String Address2;
}