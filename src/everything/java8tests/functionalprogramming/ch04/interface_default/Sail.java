package everything.java8tests.functionalprogramming.ch04.interface_default;

/**
 * Created by mcalancea on 2015-09-22.
 */
public interface Sail {
    default void turn(){
        System.out.println("Sail::turn");
    }

    default void cruise(){
        System.out.println("Sail::cruise");
    }

}
