package com.everything.java8tests.forimpatient.ch02.exercises;

import com.everything.java8tests.forimpatient.ch02.DemoAppCh02;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * User: Makar Kalancha
 * Date: 16/02/2015
 * Time: 16:57
 */
public class Exercises {
    public static void main(String[] args) throws IOException {
//        System.out.println("number 001:");
//        number001();

//        System.out.println("number 002:");
//        number002();

//        System.out.println("number 003: count long words in war & peace");
//        number003();

//        System.out.println("number 004: array int");
//        number004();

//        System.out.println("number 005: linear congruential generator");
//        number005();

//        System.out.println("number 006: characterStream");
//        String string = "stingToCharacter";
//        number006(string);

//        System.out.println("number 008: zip stream");
//        number008();

//        System.out.println("number 009: join arrays");
//        number009();

//        System.out.println("number 010: average");
//        number010();

//        System.out.println("number 012: atomic integer");
//        number012();

        System.out.println("number 013: filter short words");
        number013();
    }

    public static void number013() throws IOException {
        List<String> words = getWordsFromDemo();
        words.parallelStream().
                filter(s -> s.length() < 12).
                collect(Collectors.groupingBy(
                                String::length,
                                Collectors.counting()
                        )
                ).
                forEach((k,v)-> {
                    System.out.println(k + "->" + v);
                });
    }

    public static void number012() throws IOException{
        DemoAppCh02.func056();
    }

    public static void number010() {
        Double sumOfDouble = Stream.of(9.0, 5.0, 10.0).
                reduce(0.0,Double::sum);
        System.out.println(sumOfDouble);
        System.out.println();
        Double average = Stream.of(9.0, 5.0, 10.0).
                mapToDouble(d -> d).
                average().
                getAsDouble();
        System.out.println(average);
    }

    public static void number009() {
        ArrayList<Integer> arrayList1 = Lists.newArrayList(1, 3, 5, 7, 9);
        ArrayList<Integer> arrayList2 = Lists.newArrayList(2, 4, 6, 8, 10);
        ArrayList<Integer> arrayList3 = Lists.newArrayList(11, 13, 15, 17, 19);
        Stream<ArrayList<Integer>> arrayListStream = getStream(arrayList1, arrayList2, arrayList3);
        arrayListStream.forEach(System.out::println);

        System.out.println("---joinStreamArrayList1:");
        joinStreamArrayList1(getStream(arrayList1, arrayList2, arrayList3)).
                forEach(System.out::println);

        System.out.println("---joinStreamArrayList2:");
        joinStreamArrayList2(getStream(arrayList1, arrayList2, arrayList3)).
                forEach(System.out::println);

        System.out.println("---joinStreamArrayList3:");
        joinStreamArrayList3(getStream(arrayList1, arrayList2, arrayList3)).
                forEach(System.out::println);
    }

    public static <T> ArrayList<T> joinStreamArrayList3(Stream<ArrayList<T>> arrayListStream){
        return arrayListStream.reduce(new ArrayList<T>(),
                (a, b) -> {
                    System.out.println("a:"+a);
                    System.out.println("b:"+b);
                    System.out.println("------------");
                    a.addAll(b);
                    return a;
                },
                (l, m) -> {
                    System.out.println("l:"+l);
                    System.out.println("m:"+m);
                    System.out.println("------------");
                    l.addAll(m);
                    return l;
                }

        );
    }

    public static <T> ArrayList<T> joinStreamArrayList2(Stream<ArrayList<T>> arrayListStream){
        return arrayListStream.reduce(new ArrayList<T>(), (l, m) -> {
            l.addAll(m);
            return l;
        });
    }

    public static <T> ArrayList<T> joinStreamArrayList1(Stream<ArrayList<T>> arrayListStream){
        return arrayListStream.reduce((l, m) -> {
            l.addAll(m);
            return l;
        }).orElse(new ArrayList<T>());
    }

    public static <T> Stream<ArrayList<T>> getStream(ArrayList<T> arrayList1, ArrayList<T> arrayList2, ArrayList<T> arrayList3) {
        return Stream.of(arrayList1, arrayList2, arrayList3);
    }

    public static void number008() {
        Stream<Integer> intStream1 = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> intStream2 = Stream.of(2, 4, 6, 8, 10, 12, 14);
        Stream<Integer> zip = zip(intStream1, intStream2);
        zip.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondIterator = second.iterator();
        return first.flatMap( t -> {
                    if (secondIterator.hasNext()) {
                        System.out.println("-->" + t);
                        return Arrays.asList(t, secondIterator.next()).stream();
                    } else {
                        first.close();
                        return null;
                    }
                }
        );
    }

    public static void number006(String s) {
        Stream<Character> stream1 = s.chars().mapToObj(i -> (char) i);
        stream1.forEach(System.out::println);

        System.out.println();

        Stream<Character> stream2 = IntStream.range(0, s.length() - 1).mapToObj(i -> s.charAt(i));
        stream2.forEach(System.out::println);
    }

    public static void number005() {
        long m = (long) Math.pow(2, 48);
        long x0 = 0;
        long a = 25214903917L;
        long c = 11;
        Stream<Long> random = Stream.
                iterate(x0, xn -> (a * xn + c) % m).
                limit(25);
        random.forEach(System.out::println);
    }

    public static void number004() {
        int[] values = {1, 4, 9, 16};
        //stream cannot be applied it should be Stream<int[]>
        //Stream<Integer> stream1 = Stream.of(values);
        Stream<int[]> stream1 = Stream.of(values);
        stream1.forEach(System.out::println);
        System.out.println();
        IntStream intStream = Arrays.stream(values);
        intStream.forEach(System.out::println);
    }

    public static void number003() throws IOException {
        List<String> words = getWordsFromWarAndPeace();

        long start = 0;
        long count = 0;
        long end = 0;
        long time = 0;
        Predicate<String> function = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 7;
            }
        };

        start = System.currentTimeMillis();
        System.out.println("Non parallel:");
        System.out.println("start: "+start);

        count = words.stream().
                filter(function).
                count();

        end = System.currentTimeMillis();
        System.out.println("end: "+end);
        time = end - start;
        System.out.println("time:"+time+"; count:"+count);

        System.out.println();
        start = System.currentTimeMillis();
        System.out.println("Parallel:");
        System.out.println("start: "+start);

        count = words.stream().
                parallel().
                filter(function).
                count();

        end = System.currentTimeMillis();
        System.out.println("end: "+end);
        time = end - start;
        System.out.println("time:"+time+"; count:"+count);

//        Whatever the kind of tasks to parallelize, the strategy applied by parallel streams will be the same, unless you devise this strategy yourself, which will remove much of the interest of parallel streams. Parallelization requires:
//            A pool of threads to execute the subtasks,
//            Dividing the initial task into subtasks,
//            Distributing subtasks to threads,
//            Collating the results.
//        Without entering the details, all this implies some overhead.
//        parallel is slower than non parallel
        System.out.println("words: "+words.size());
    }

    public static void number002() throws IOException {
        List<String> list = getWordsFromDemo().stream().filter(x -> {
            boolean result = x.length() < 4;
            System.out.println(x + " --> " + result);
            return result;
        }).limit(5).
        collect(Collectors.toList());
        System.out.println(list);
    }

    public static void number001() throws IOException{
        List<String> words = getWordsFromDemo();

        int numberOfProcessorsAvailable = Runtime.getRuntime().availableProcessors();
        AtomicInteger count = new AtomicInteger(0);
        System.out.println(numberOfProcessorsAvailable);

        System.out.println(words.size());
        int limit = (int) Math.ceil(words.size() / Float.valueOf(numberOfProcessorsAvailable));
        System.out.println(limit);

        for (int i = 0; i < numberOfProcessorsAvailable; i++) {
            Num001Counter counter = new Num001Counter(words, i, limit, count);
            Thread thread = new Thread(counter);
            thread.start();
            try {
                thread.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("final count:"+count);
    }

    public static List<String> getWordsFromDemo() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\com.everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        final List<String> words = Arrays.asList(content.split("[\\P{L}]+"));
        return words;
    }

    public static List<String> getWordsFromWarAndPeace() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\com.everything\\java8tests\\war_and_peace.txt")), StandardCharsets.UTF_8);
        //        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        final List<String> words = Arrays.asList(content.split("[\\P{L}]+"));
        return words;
    }
}
