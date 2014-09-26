package everything;

/**
 * User: Makar Kalancha
 * Date: 04/12/13
 * Time: 2:50 PM
 */
public class IfCheck {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for(int i : arr){
            System.out.println(i+" randomNumber="+isGreaterOfTwo(i));
            if(isGreaterOfTwo(i))
            {
                System.out.println("no semicolon: true");
            }else{
                System.out.println("no semicolon: false");
            }

            if(isGreaterOfTwo(i));

            {
                System.out.println("with semicolon: true");
            }
//            else{
//                System.out.println("with semicolon: false");
//            }
        }
    }

    public static boolean isGreaterOfTwo(int num){
        return num > 2;
    }
}
