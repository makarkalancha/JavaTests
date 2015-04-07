package everything.numbertest;

import com.google.common.math.DoubleMath;
import com.sun.media.sound.SoftTuning;

/**
 * Created by mcalancea on 2015-04-07.
 */
public class DoubleTests {
    private static final double TOLERANCE = 1e-16;

    public static void main(String[] args) {
        double numberENotation = 1e-6;
        double number = 0.000001;
        System.out.println(numberENotation);
        System.out.println(number);

        boolean equal = DoubleMath.fuzzyEquals(numberENotation, number, TOLERANCE);
        System.out.printf("%1$f == %2$f: %3$b\n", numberENotation, number, equal);
    }
}
