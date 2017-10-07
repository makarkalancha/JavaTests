package com.everything;

import java.io.File;
import java.util.Locale;

/**
 * User: Makar Kalancha
 * Date: 12/06/14
 * Time: 12:01 PM
 */
public class RuntimeTest {

    public static void main(String[] args) {
        System.out.println("Available processors: "+Runtime.getRuntime().availableProcessors());
        System.out.println("Free memory (bytes): "+Runtime.getRuntime().freeMemory()+"->"+convertBytes(Runtime.getRuntime().freeMemory(), Unit.MiB));
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Maximum memory (bytes):" + (maxMemory == Long.MAX_VALUE ? "no limit" : "->" + convertBytes(maxMemory, Unit.MiB)));
        System.out.println("Total memory (bytes): "+Runtime.getRuntime().totalMemory()+"->"+convertBytes(Runtime.getRuntime().totalMemory(), Unit.MiB));
        File[] roots = File.listRoots();
        for(File root : roots){
            System.out.println("File system root: " +root.getAbsolutePath());
            System.out.println("Total space (bytes): " +root.getTotalSpace());
            System.out.println("Free space (bytes): " + root.getFreeSpace());
            System.out.println("Usable space (bytes): " + root.getUsableSpace());
        }

//        long bytes = 2861563904L;
//        System.out.println(convertBytes(bytes,Unit.Bytes));
//        System.out.println(convertBytes(bytes, Unit.KiB));
//        System.out.println(convertBytes(bytes, Unit.MiB));
//        System.out.println(convertBytes(bytes, Unit.GiB));
//
//        System.out.println(((double) 1056) / 1024);
    }

    private enum Unit{Bytes,KiB,MiB,GiB}

    private static String convertBytes(long bytes,Unit unit) {
        String result = "";
        double bytesD = 0;
        switch (unit){
            case KiB:
                bytesD= ((double)bytes) / 1024;
                result = String.format(Locale.FRANCE,"%,.2f",bytesD) + " " + unit;
                break;
            case MiB:
                bytesD= ((double)bytes) / 1024 / 1024;
                result = String.format(Locale.FRANCE,"%,.2f",bytesD) + " " + unit;
                break;
            case GiB:
                bytesD = ((double)bytes) / 1024 / 1024 / 1024;
                result = String.format(Locale.FRANCE,"%,.2f",bytesD) + " " + unit;
                break;
            default:
                result = String.format(Locale.FRANCE,"%,d",bytes) + " "+unit;
                break;
        }

        return result;
    }
}
