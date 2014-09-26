package everything;


/**
 * User: Makar Kalancha
 * Date: 17/09/14
 * Time: 10:43 AM
 */
public class PassByValueDemo {
    public static void main(String[] args) {
        Target target = new Target();
        target.process();
    }
    private static class Target{
        private String value;

        private String changeValue(){
            if(value == null) {
                value = "default value";
            }
            return value;
        }

        public void doSomething1() {
//            changeValue();
            Client.changeValue(value);
        }

        public void doSomething2() {
//            changeValue();
            Client.changeValue(value);
        }

        public void process(){
            doSomething1();
            doSomething2();
        }
    }

    private static class Client{
        public static String changeValue(String value){
            if(value == null) {
                value = "default value";
            }
            return value;
        }
    }
}


