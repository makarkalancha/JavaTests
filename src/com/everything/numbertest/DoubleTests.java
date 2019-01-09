package com.everything.numbertest;

/**
 * Created by mcalancea on 2015-04-07.
 */
public class DoubleTests {
    private static final double TOLERANCE = 1e-16;

    public static void main(String[] args) throws Exception{
//        double numberENotation = 1e-6;
//        double number = 0.000001;
//        System.out.println(numberENotation);
//        System.out.println(number);
//
//        boolean equal = DoubleMath.fuzzyEquals(numberENotation, number, TOLERANCE);
//        System.out.printf("%1$f == %2$f: %3$b\n", numberENotation, number, equal);

//        double percentage = (double) 20L / 46;
//        System.out.println(percentage);

        final int BATCH_SIZE = 50;

        long totalSize = 2;
        long totalBatches = (long) Math.ceil((double) totalSize / BATCH_SIZE);
        long progress = 0;
        for (int i = 1; i <= totalBatches; i++) {
            progress = (i * BATCH_SIZE > totalSize) ? totalSize : i * BATCH_SIZE;
            int percent = new Double(((double) progress / totalSize) * 100).intValue();
            System.out.println("batch#: " + i + "; progress: " + progress + "; percent: " + percent);
            Thread.sleep(1000);
        }

        float difference = Math.abs((2 - 10) * .05f);
        System.out.println(difference);

    }
}
