package everything.java8tests.functionalprogramming.ch07.factorial;

/**
 * Created by mcalancea on 2015-10-08.
 */
public class Factorial {
    public static int factorialRec(int number){
        if(number == 1){
            return number;
        } else {
            return number * factorialRec(number - 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(factorialRec(5));

        try{
            System.out.println(factorialRec(20_000));
        }catch (StackOverflowError ex){
            ex.printStackTrace();
        }
    }

}
