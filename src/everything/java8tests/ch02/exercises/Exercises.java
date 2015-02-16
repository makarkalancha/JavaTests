package everything.java8tests.ch02.exercises;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: Makar Kalancha
 * Date: 16/02/2015
 * Time: 16:57
 */
public class Exercises {
    public static void main(String[] args) throws IOException{
        System.out.println("number 001:");
        number001();
    }

    public static void number001() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        final List<String> words = Arrays.asList(content.split("[\\P{L}]+"));

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
}
