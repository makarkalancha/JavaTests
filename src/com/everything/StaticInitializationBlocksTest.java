package com.everything;

/**
 * User: Makar Kalancha
 * Date: 25/03/2016
 * Time: 17:33
 */
public class StaticInitializationBlocksTest {
    public static void main(String[] args) {
        TestClass first = new TestClass("first");
        TestClass second = new TestClass("second");

        System.out.println("first:" + first.returnFieldStrB());
        System.out.println("second:" + second.returnFieldStrB());
    }

    private static class TestClass {
        private static final String PLACE_HOLDER = "{{string}}";
        private static final StringBuilder fieldStrB = new StringBuilder();
        static {
            fieldStrB.append("hello ");
            fieldStrB.append(PLACE_HOLDER);
            fieldStrB.append(" world");
        }

        public TestClass(String name){
            System.out.println("before fieldStrB: " + fieldStrB);
            System.out.println("fieldStrB.indexOf(PLACE_HOLDER): " + fieldStrB.indexOf(PLACE_HOLDER));
            System.out.println("fieldStrB.indexOf(PLACE_HOLDER)+PLACE_HOLDER.length(): " + (fieldStrB.indexOf(PLACE_HOLDER) + PLACE_HOLDER.length()));
            fieldStrB.replace(
                    fieldStrB.indexOf(PLACE_HOLDER),
                    fieldStrB.indexOf(PLACE_HOLDER) + PLACE_HOLDER.length(),
                    name
            );
            System.out.println("after fieldStrB:"+fieldStrB);
        }

        public String returnFieldStrB(){
            return fieldStrB.toString();
        }

    }
}
