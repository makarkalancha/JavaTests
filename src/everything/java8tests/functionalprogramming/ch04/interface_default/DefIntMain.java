package everything.java8tests.functionalprogramming.ch04.interface_default;

/**
 * Created by mcalancea on 2015-09-22.
 */
public class DefIntMain {

    public static void main(String[] args) {
        SeaPlane seaPlane1 = new SeaPlane(100);
        SeaPlane seaPlane2 = new SeaPlane(-100);

        seaPlane1.cruise();
        seaPlane1.land();
        seaPlane1.takeOff();
        seaPlane1.turn();

        seaPlane2.cruise();

    }
}
