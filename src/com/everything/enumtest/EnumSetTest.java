package com.everything.enumtest;

import org.apache.commons.lang3.EnumUtils;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by mcalancea on 2015-03-30.
 */
public class EnumSetTest {
    private enum Color{
        RED(255,0,0), GREEN(0,255,0), BLUE(0, 0, 255),;
        private int red;
        private int green;
        private int blue;
        private Color(int r, int g, int b){
            this.red = r;
            this.green = g;
            this.blue = b;
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }

        @Override
        public String toString() {
            return this.getDeclaringClass().getSimpleName().toString() + "." + this.name();
        }
    }

    public static void drawLine(Set<Color> colors){
        System.out.println("Requested Colors to draw lines: "+colors);
        for(Color c : colors) {
            System.out.println("drawing line in color: " + c);
        }
    }

    public static void main(String[] args) {
//        EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN);
//        drawLine(yellow);
//
//        EnumSet<Color> white = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
//        drawLine(white);
//
//        EnumSet<Color> pink = EnumSet.of(Color.RED, Color.BLUE);
//        drawLine(pink);

//        System.out.println("red:"+Color.valueOf("red".toUpperCase()));
//        System.out.println(Color.RED);

        System.out.println("RED: " + EnumUtils.isValidEnum(Color.class, "RED"));
        System.out.println("RED1: " + EnumUtils.isValidEnum(Color.class, "RED1"));

        EnumSet<Color> pink = EnumSet.of(Color.RED, Color.BLUE);
        System.out.println(EnumSet.complementOf(pink));
        System.out.println(EnumSet.copyOf(pink));
        System.out.println("---------------------------------------");
        EnumSet<Color> pink2 = EnumSet.copyOf(pink);
        pink2.add(Color.GREEN);
        System.out.println(pink);
        System.out.println(pink2);
        System.out.println("---------------------------------------");
        EnumSet<Color> pink3 = pink;
        pink3.remove(Color.BLUE);
        System.out.println(pink);
        System.out.println(pink2);
        System.out.println(pink3);


        String blue1 = "BLUE1";
//        Color colorBlue1 = Color.valueOf(blue1);
//        System.out.println(colorBlue1);

        System.out.println(EnumUtils.isValidEnum(Color.class, blue1));

    }
}
