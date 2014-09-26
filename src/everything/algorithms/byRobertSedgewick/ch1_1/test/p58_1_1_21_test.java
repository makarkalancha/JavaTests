package everything.algorithms.byRobertSedgewick.ch1_1.test;

import everything.algorithms.byRobertSedgewick.ch1_1.p58_1_1_21;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: Makar Kalancha
 * Date: 29/05/14
 * Time: 1:17 PM
 */

//@RunWith(p58_1_1_21.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({
        p58_1_1_21_test.testPass1.class,
        p58_1_1_21_test.testPass2ExtraSpace.class,
        p58_1_1_21_test.testFail1NoSpace.class,
        p58_1_1_21_test.testPass4FirstDecimal.class,
        p58_1_1_21_test.testPass5SecondDecimal.class,
        p58_1_1_21_test.testPass6BothDecimal.class,
})
public class p58_1_1_21_test{


    public static class testPass1 extends TestCase{
        private String _inputString;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            _inputString = "name 3 2";
    //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            _inputString = null;
    //        System.out.println("@Override - tearDown");
        }

    //    @Ignore ("not ready")
        @Test
        public void testPass1(){
            boolean resultTrue = true;
            p58_1_1_21 instance = new p58_1_1_21();
            boolean test = instance.isValidString(_inputString);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass1");
        }

        @BeforeClass
        public static void oneTimeSetUp(){
            System.out.println("@BeforeClass - oneTimeSetUp");
        }

        @AfterClass
        public static void oneTimeTearDown(){
            System.out.println("@AfterClass - oneTimeTearDown");
        }
    }

    public static class testPass2ExtraSpace extends TestCase{
        private String _inputString;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            _inputString = "name  3 2";
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            _inputString = null;
            //        System.out.println("@Override - tearDown");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPass2ExtraSpace(){
            boolean resultTrue = true;
            p58_1_1_21 instance = new p58_1_1_21();
            boolean test = instance.isValidString(_inputString);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass2ExtraSpace");
        }
    }

    public static class testFail1NoSpace extends TestCase{
        private String _inputString;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            _inputString = "name3 2";
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            _inputString = null;
            //        System.out.println("@Override - tearDown");
        }

        //    @Ignore ("not ready")
        @Test
        public void testFail1NoSpace(){
            boolean resultTrue = false;
            p58_1_1_21 instance = new p58_1_1_21();
            boolean test = instance.isValidString(_inputString);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testFail1NoSpace");
        }
    }

    public static class testPass4FirstDecimal extends TestCase{
        private String _inputString;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            _inputString = "name 3.5 2";
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            _inputString = null;
            //        System.out.println("@Override - tearDown");
        }

        @Test
        public void testPass4FirstDecimal(){
            boolean resultTrue = true;
            p58_1_1_21 instance = new p58_1_1_21();
            boolean test = instance.isValidString(_inputString);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass4FirstDecimal");
        }
    }

    public static class testPass5SecondDecimal extends TestCase{
        private String _inputString;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            _inputString = "name 3 2.1";
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            _inputString = null;
            //        System.out.println("@Override - tearDown");
        }

        @Test
        public void testPass5SecondDecimal(){
            boolean resultTrue = true;
            p58_1_1_21 instance = new p58_1_1_21();
            boolean test = instance.isValidString(_inputString);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass5SecondDecimal");
        }
    }

    public static class testPass6BothDecimal extends TestCase{
        private String _inputString;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            _inputString = "name 3.6 2.1";
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            _inputString = null;
            //        System.out.println("@Override - tearDown");
        }

        @Test
        public void testPass6BothDecimal(){
            boolean resultTrue = true;
            p58_1_1_21 instance = new p58_1_1_21();
            boolean test = instance.isValidString(_inputString);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass6BothDecimal");
        }
    }
//

//

//

//

//

//

}
