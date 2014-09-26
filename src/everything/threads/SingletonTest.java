package everything.threads;

/**
 * User: Makar Kalancha
 * Date: 04/11/13
 * Time: 9:23 AM
 */
public class SingletonTest {
    public static void main(String [] args){
        SingletonBase a = SingletonBase.getInstance();

    }

}

class SingletonBase {
    private static SingletonBase instance = null;


    private SingletonBase(){
//        System.out.println("everything.threads.SingletonBase constructor");
        System.out.println("everything.threads.SingletonBase constructor");
    }

    public static SingletonBase getInstance(){
        if(instance == null){
            synchronized (SingletonBase.class){
                if(instance == null){
                    instance = new SingletonBase();
                    System.out.println("getInstance: create an instance");
                }
            }
        }
        return instance;
    }
}

//class SingletonDerived extends everything.threads.SingletonBase{
//    private static SingletonDerived instance = null;
//
//    public static SingletonDerived getInstance(){
//        if(instance == null){
//            synchronized (everything.threads.SingletonBase.class){
//                if(instance == null){
//                    instance = new everything.threads.SingletonBase();
//                    System.out.println("getInstance: create an instance");
//                }
//            }
//        }
//        return instance;
//    }
//}
