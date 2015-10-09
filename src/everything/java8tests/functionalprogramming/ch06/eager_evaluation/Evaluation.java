package everything.java8tests.functionalprogramming.ch06.eager_evaluation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/**
 * Created by mcalancea on 2015-09-25.
 */
public class Evaluation {
    public static boolean evaluate(final int value){
        System.out.println("evaluating... "+value);
        simulateTimeConsumingOp(2000);
        return value > 100;
    }

    private static void simulateTimeConsumingOp(final int millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void eagerEvaluator(final boolean input1, final boolean input2){
        System.out.println("eagerEvaluator called...");
        System.out.println("accept?:"+(input1 && input2));
    }

    public static void lazyEvaluator(final Supplier<Boolean> input1, Supplier<Boolean> input2){
        System.out.println("lazyEvaluator called...");
        System.out.println("accept?:"+(input1.get() && input2.get()));
    }

    public static void main(String[] args) {
//        long start = 0L;
//        long end = 0L;
//        Date startDate = new Date();
//        Date endDate = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat();
//
//        start = System.currentTimeMillis();
//        eagerEvaluator(evaluate(1), evaluate(2));
//        end = System.currentTimeMillis();
//        startDate.setTime(start);
//        endDate.setTime(end);
//        System.out.println("start: " + sdf.format(startDate));
//        System.out.println("end: " + sdf.format(endDate));
//        System.out.println("lasted: " + (end - start));
//        System.out.println("=========================================================");
//        start = System.currentTimeMillis();
//        lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
//        end = System.currentTimeMillis();
//        startDate.setTime(start);
//        endDate.setTime(end);
//        System.out.println("start: " + sdf.format(startDate));
//        System.out.println("end: " + sdf.format(endDate));
//        System.out.println("lasted: " + (end - start));

        wrap(()->eagerEvaluator(evaluate(1), evaluate(2)));
        System.out.println("=========================================================");
        wrap(() -> lazyEvaluator(() -> evaluate(1), () -> evaluate(2)));
    }

    public static void wrap(RunFunction runFunction){
        long start = 0L;
        long end = 0L;
        Date startDate = new Date();
        Date endDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();

        start = System.currentTimeMillis();
        runFunction.runIt();
        end = System.currentTimeMillis();
        startDate.setTime(start);
        endDate.setTime(end);
        System.out.println("start: " + sdf.format(startDate));
        System.out.println("end: " + sdf.format(endDate));
        System.out.println("lasted: " + (end - start));
    }

    @FunctionalInterface
    interface RunFunction{
        void runIt();
    }
}
