package everything.java8tests.ch03;

import javax.sound.midi.Soundbank;
import java.util.function.Supplier;

/**
 * User: Makar Kalancha
 * Date: 17/02/2015
 * Time: 15:04
 */
public class DemoAppCh03 {
    public static void main(String[] args) {
        System.out.println("func001: supplier");
        func001();
    }

    public static void func001(){
//        String variable = null;
        String variable = "world";
        info(variable, () -> "hello: "+variable);
    }

    public static void info(String string, Supplier<String> message){
        if(string != null){
            System.out.println(message.get());
        }
    }
}
