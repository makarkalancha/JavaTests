package everything;

/**
 * User: Makar Kalancha
 * Date: 15/05/14
 * Time: 11:18 AM
 */
public class ShutDownHookTest {
    public static void main(String[] args) {
        ShutDownHookTest test = new ShutDownHookTest();
        System.out.println("shutdown hook instanciated");
        test.attachShutdownHook();
        System.exit(0);
    }

    private void attachShutdownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("inside shudown hook");
            }
        });
        System.out.println("shutdown hook attached");
    }
}
