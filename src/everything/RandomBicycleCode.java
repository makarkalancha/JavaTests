package everything;

import java.util.Random;

/**
 * User: Makar Kalancha
 * Date: 07/02/2016
 * Time: 13:38
 */
public class RandomBicycleCode {
    private final static int MIN = 0;
    private final static int MAX = 9;
    private final static char[] roller1 = {'R','F','B','L','P','W','S','T','D','M'};
    private final static char[] roller2 = {'E','H','W','R','Y','U','A','I','O','L'};
    private final static char[] roller3 = {'E','R','M','T','N','S','K','O','A','L'};
    private final static char[] roller4 = {'D','G','K','M','S','T','E','P','Y','L'};
    private final static char[][] rollerMatrix = {roller1, roller2, roller3, roller4};
    private final static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("1>>>>"+getBicycleCode());
        System.out.println("2>>>>"+getBicycleCode());
        System.out.println("3>>>>"+getBicycleCode());
        System.out.println("4>>>>"+getBicycleCode());

//        int roll1 = MIN + random.nextInt(MAX-MIN+1);
//        int roll2 = MIN + random.nextInt(MAX-MIN+1);
//        int roll3 = MIN + random.nextInt(MAX-MIN+1);
//        int roll4 = MIN + random.nextInt(MAX-MIN+1);
//        System.out.println(roll1);
//        System.out.println(roll2);
//        System.out.println(roll3);
//        System.out.println(roll4);
    }

    private static String getBicycleCode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int roll = MIN + random.nextInt(MAX - MIN + 1);
            System.out.println("number: "+roll+"; letter:" + rollerMatrix[i][roll]);
            sb.append(rollerMatrix[i][roll]);
        }
        return sb.toString();
    }
}
