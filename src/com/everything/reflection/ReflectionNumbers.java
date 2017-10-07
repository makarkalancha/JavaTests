package com.everything.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Makar Kalancha
 * Date: 18 Jul 2017
 * Time: 09:56
 */
public class ReflectionNumbers {
    public static void main(String[] args) throws Exception{
        for( Field field : NumberClass.class.getDeclaredFields()) {
//            Field field = NumberClass.class.getDeclaredField("anInt");
//            boolean isNumber = Number.class.isAssignableFrom(field.getGenericType().getClass());
            boolean isNumber = Number.class.isAssignableFrom(field.getType());
            System.out.println(field.getName() + ": NUMBER=" + isNumber + "; PRIMITIVE=" + field.getType().isPrimitive());
        }
    }

    private static class NumberClass{
        private boolean aBoolean;
        private Boolean aBooleanObj;
        private char aChar;
        private Character aCharObj;
        private int anInt;
        private Integer anIntObj;
        private short aShort;
        private Short aShortObj;
        private long aLong;
        private Long aLongObj;
        private double aDouble;
        private Double aDoubleObj;
        private float aFloat;
        private Float aFloatObj;
        private BigDecimal bigDecimal;
        private BigInteger bigInteger;

        private String string;
    }
}
