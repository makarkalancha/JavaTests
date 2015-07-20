package everything.java8tests.forimpatient.ch01.exercises;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 02/02/2015
 * Time: 11:54
 */
public class Exercises {
    public static void main(String[] args) {
//        System.out.println("#002:");
//        Exercises.number02();

//        System.out.println("#003:");
//        Exercises.number03();

//        System.out.println("#004:");
//        Exercises.number04();

//        System.out.println("#006:");
//        Exercises.number06();

//        System.out.println("#007:");
//        Exercises.number07();

        System.out.println("#008:");
        Exercises.number08();
    }

    public static void number08() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for(String name : names){
            runners.add(()-> System.out.println(name));
        }

        for(Runnable runnable : runners){
            new Thread(runnable).start();
        }
    }

    public static void number07() {
        new Thread(andThen(
                () -> System.out.println("hello"),
                () -> System.out.println("bye")
        )).start();
    }

    public static Runnable andThen(Runnable runnable1, Runnable runnable2){
        return ()->{
            try {
                runnable1.run();
                Thread.sleep(2000);
                runnable2.run();
            }catch (InterruptedException e) {
                e.getStackTrace();
            }
        };
    }

    public static void number06(){
        new Thread(uncheck(
                ()-> {
                    System.out.println("Zzz");
                    Thread.sleep(2000);
                    System.out.println("Zzzzzzzzzzzzz");
                }
        )).start();
    }

    public static Runnable uncheck(RunnableEx runnableEx){
        return ()->{
            try{
                runnableEx.run();
            }catch (Exception e){
                System.out.println("Exception:"+e.getMessage());
            }
        };
    }

    public static void number04(){
        String rootDir = "d:\\";
        File fileRoot = new File(rootDir);
        System.out.println("java prior 8");
        File[] subdirs = fileRoot.listFiles();
        Arrays.sort(subdirs, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if ((o1.isDirectory() && o2.isDirectory()) || (o1.isFile() && o2.isFile())) {
                    return o1.compareTo(o2);
                } else if(o1.isDirectory() && o2.isFile()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for(File subdir : subdirs){
            System.out.println(subdir.getAbsolutePath());
        }

        System.out.println("\njava 8");
        File[] files = fileRoot.listFiles();
        Arrays.sort(files, (File o1, File o2) -> {
            if ((o1.isDirectory() && o2.isDirectory()) || (o1.isFile() && o2.isFile())) {
                return o1.compareTo(o2);
            } else if (o1.isDirectory() && o2.isFile()) {
                return -1;
            } else {
                return 1;
            }
        });
        Arrays.stream(files).forEach(System.out::println);
    }

    public static void number03(){
        String rootDir = "d:\\";
        File fileRoot = new File(rootDir);
        System.out.println("java prior 8");
        File[] subdirs = fileRoot.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        for(File subdir : subdirs){
            System.out.println(subdir.getAbsolutePath());
        }

        System.out.println("\njava 8");
        Arrays.stream(
                fileRoot.listFiles((File dir, String name) -> name.toLowerCase().endsWith(".txt"))
        ).forEach(System.out::println);
    }

    public static void number02(){
        String rootDir = "d:\\";
        File fileRoot = new File(rootDir);
        System.out.println("java prior 8");
        File[] subdirs = fileRoot.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for(File subdir : subdirs){
            System.out.println(subdir.getAbsolutePath());
        }

        System.out.println("\njava 8");
        Arrays.stream(
                fileRoot.listFiles((File pathname) -> pathname.isDirectory())
        ).forEach(System.out::println);
    }
}
