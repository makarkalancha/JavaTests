package everything.java8tests.ch02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 02/02/2015
 * Time: 15:02
 */
public class DemoAppCh02 {
    public static void main(String[] args) {
        System.out.println("func#001");
        try {
            DemoAppCh02.func001();
        }catch (IOException e) {
            e.getStackTrace();
        }
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
    }
}
