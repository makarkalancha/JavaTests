package everything.java8tests.ch02;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * User: Makar Kalancha
 * Date: 02/02/2015
 * Time: 15:02
 */
public class DemoAppCh02 {
    public static void main(String[] args)  throws IOException{
//        System.out.println("func#001");
//        DemoAppCh02.func001();

//        System.out.println("func#002");
//        DemoAppCh02.func002();

//        System.out.println("func#003: infinite streams");
//        DemoAppCh02.func003();

//        System.out.println("func#004: iterate streams");
//        DemoAppCh02.func004();

//        System.out.println("func#005: pattern streams");
//        DemoAppCh02.func005();

//        System.out.println("func#006: lines auto close streams");
//        DemoAppCh02.func006();

//        System.out.println("func#007: list streams");
//        DemoAppCh02.func007();

//        System.out.println("func#008: lower case streams");
//        DemoAppCh02.func008();

//        System.out.println("func#009: first character streams");
//        DemoAppCh02.func009();

//        System.out.println("func#010: character streams");
//        DemoAppCh02.func010();

//        System.out.println("func#011: infinite streams with limit");
//        DemoAppCh02.func011();

//        System.out.println("func#012: skip 2 streams");
//        DemoAppCh02.func012();

//        System.out.println("func#013: concat streams");
//        DemoAppCh02.func013();

//        System.out.println("func#014: peek streams");
//        DemoAppCh02.func014();

        System.out.println("func#015: distinct");
        DemoAppCh02.func015();
    }

    public static void func015() {
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        uniqueWords.forEach(System.out::println);
    }

    public static void func014() {
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray();
        System.out.println(Arrays.toString(powers));
    }

    public static void func013() {
        Stream<Character> characterStream = Stream.concat(characterStream("hello"),characterStream("world"));
        characterStream.forEach(System.out::println);
    }

    public static void func012() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> stream = wordList.stream().skip(2);
        stream.forEach(System.out::println);
    }

    public static void func011() {
        System.out.println("random from 7 to 22");
        Stream<Integer> stream = Stream.generate(() -> (int)(Math.random() * 20 + 7)).limit(10);
        stream.forEach(System.out::println);
    }

    public static void func010() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        System.out.println("stream of stream:");
        Stream<Stream<Character>> characterStream = wordList.stream().map(w -> characterStream(w));
        characterStream.forEach(stream -> stream.forEach(System.out::println));

        System.out.println("\nflat map:");
        Stream<Character> characterStream1 = wordList.stream().flatMap(w -> characterStream(w));
        characterStream1.forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for(char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }


    public static void func009() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> wordStream = wordList.stream();
        Stream<Character> charAtWordStream = wordStream.map(s -> s.charAt(0));
        charAtWordStream.forEach(System.out::println);
    }

    public static void func008() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> wordStream = wordList.stream();

        Stream<String> lowerCaseWordStream = wordStream.map(String::toLowerCase);
        lowerCaseWordStream.forEach(System.out::println);
    }

    public static void func007() {
        List<String> wordList = new ArrayList<>();
        wordList.add("add");
        wordList.add("me");
        wordList.add("to");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> wordStream = wordList.stream();
//        wordStream.forEach(System.out::println);

        Stream<String> longWordStream = wordStream.filter(w -> w.length() > 2);
        longWordStream.forEach(System.out::println);
    }

    public static void func006() throws IOException {
        try(Stream<String> lines = Files.lines(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java"))){
            lines.forEach(System.out::println);
        }
    }

    public static void func005() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);
        words.forEach(System.out::println);
    }

    public static void func004() {
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        integers.forEach(System.out::println);
    }

    public static void func003() {
        Stream<String> stream1 = Stream.generate(() -> "echo");
//        stream1.forEach(System.out::println);

        Stream<Double> stream2 = Stream.generate(Math::random);
//        stream2.forEach(System.out::println);
    }

    public static void func002() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        Stream<String> words1 = Stream.of(content.split("[\\P{L}]+"));
        System.out.println("words1:");
        words1.forEach(System.out::println);

        Stream<String> words2 = Stream.of("gently","down","the","stream");
        System.out.println("\nwords2:");
        words2.forEach(System.out::println);

    }

    public static void func001() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        List<String> words = Arrays.asList(content.split("[\\P{L}]+"));

        System.out.println("java prior version 8");
        int countFilter = 0;
        int countAll = 0;
        for(String word : words){
            if(word.length()>12) {
                System.out.println(word);
                countFilter++;
            }
            countAll++;
        }
        System.out.println("count, length > 12:"+countFilter);
        System.out.println("count all:"+countAll);

        System.out.println("\njava 8");
        long countFilterJava8 = words.stream().filter(w -> w.length() > 12).count();
        words.stream().filter(w -> w.length() > 12).forEach(System.out::println);
        System.out.println("count, length > 12:"+countFilterJava8);

        long countFilterParallel=words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println("\nparallel stream, count, length > 12:"+countFilterParallel);
    }
}
