package com.everything.reflection;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by mcalancea on 2015-04-28.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Class clazz=UseTestClass.class;
        Field[] fields = clazz.getFields();
        for(Field field : fields) {
            System.out.println(field.getType().getSimpleName()+":"+StringUtils.isAllUpperCase(field.getType().getSimpleName()));
        }
    }
}
