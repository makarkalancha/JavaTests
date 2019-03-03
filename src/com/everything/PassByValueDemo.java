package com.everything;


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
            System.out.println("Target.changeValue->value = "+value);
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
            System.out.println("first Target.process->value = "+value);
            doSomething1();
            System.out.println("after doSomething1 Target.process->value = " + value);
            doSomething2();
            System.out.println("after doSomething2 Target.process->value = " + value);
            changeValue();
            System.out.println("after changeValue Target.process->value = " + value);
        }
    }

    private static class Client{
        public static String changeValue(String value){
            if(value == null) {
                value = "default value";
            }
            System.out.println("Client.changeValue->value = "+value);
            return value;
        }
    }
}


