package everything.java8tests.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 15:19
 */
public class ConcurrentGreeter extends Greeter {
    @Override
    public void greet() {
//        Thread t = new Thread(super::greet);
        Thread t = new Thread(() -> {
            super.greet();
        });
        t.start();
    }
}
