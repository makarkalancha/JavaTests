package everything.effectivejava.ch06;


/**
 * Created by mcalancea on 2016-02-03.
 */
public class PhaseDemo {

    public static void main(String[] args) {
        System.out.println(Phase.Transition.FREEZE);
        System.out.println(Phase.Transition.from(Phase.GAS,Phase.SOLID));
    }

}
