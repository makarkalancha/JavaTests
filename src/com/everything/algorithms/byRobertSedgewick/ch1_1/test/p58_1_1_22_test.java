package com.everything.algorithms.byRobertSedgewick.ch1_1.test;

import com.everything.algorithms.byRobertSedgewick.ch1_1.p58_1_1_22;
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
//        p58_1_1_22_test.testPass1.class,
//        p58_1_1_22_test.testPass2.class,
//        p58_1_1_22_test.testPass3.class,
//        p58_1_1_22_test.testPass4.class,
//        p58_1_1_22_test.testPass5.class,
//        p58_1_1_22_test.testPass6.class,
//        p58_1_1_22_test.testFail1.class,
        p58_1_1_22_test.testPassRecursive1.class,
        p58_1_1_22_test.testPassRecursive2.class,
        p58_1_1_22_test.testPassRecursive3.class,
        p58_1_1_22_test.testPassRecursive4.class,
        p58_1_1_22_test.testPassRecursive5.class,
        p58_1_1_22_test.testPassRecursive6.class,
        p58_1_1_22_test.testFailRecursive1.class,
})
public class p58_1_1_22_test {
    private static int [] _array = {1, 3, 5, 12, 35, 100};

    public static class testPass1 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 1;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

    //    @Ignore ("not ready")
        @Test
        public void testPass1(){
            int resultTrue = 0;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass1: needle="+needle+"; result="+resultTrue);
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

    public static class testPass2 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 3;
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            //        System.out.println("@Override - tearDown");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPass2(){
            int resultTrue = 1;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array,needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass2: needle="+needle+"; result="+resultTrue);
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

    public static class testPass3 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 5;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPass3(){
            int resultTrue = 2;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array,needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass3: needle="+needle+"; result="+resultTrue);
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

    public static class testPass4 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 12;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPass4(){
            int resultTrue = 3;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array,needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass4: needle="+needle+"; result="+resultTrue);
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

    public static class testPass5 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 35;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPass5(){
            int resultTrue = 4;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array,needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass5: needle="+needle+"; result="+resultTrue);
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

    public static class testPass6 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 100;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPass6(){
            int resultTrue = 5;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array,needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPass6: needle="+needle+"; result="+resultTrue);
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

    public static class testFail1 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 2;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testFail1(){
            int resultTrue = -1;
            int test = p58_1_1_22.binarySearch(p58_1_1_22_test._array,needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testFail1: needle="+needle+"; result="+resultTrue);
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


    public static class testPassRecursive1 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 1;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPassRecursive1(){
            int resultTrue = 0;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPassRecursive1: needle="+needle+"; result="+resultTrue);
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

    public static class testPassRecursive2 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 3;
            //        System.out.println("@Override - setUp");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            //        System.out.println("@Override - tearDown");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPassRecursive2(){
            int resultTrue = 1;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPassRecursive2: needle="+needle+"; result="+resultTrue);
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

    public static class testPassRecursive3 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 5;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPassRecursive3(){
            int resultTrue = 2;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPassRecursive3: needle="+needle+"; result="+resultTrue);
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

    public static class testPassRecursive4 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 12;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPassRecursive4(){
            int resultTrue = 3;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPassRecursive4: needle="+needle+"; result="+resultTrue);
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

    public static class testPassRecursive5 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 35;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPassRecursive5(){
            int resultTrue = 4;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPassRecursive5: needle="+needle+"; result="+resultTrue);
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

    public static class testPassRecursive6 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 100;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testPassRecursive6(){
            int resultTrue = 5;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testPassRecursive6: needle="+needle+"; result="+resultTrue);
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

    public static class testFailRecursive1 extends TestCase{
        int needle;
        @Override
        protected void setUp() throws Exception {
            super.setUp();
            needle = 2;
            System.out.println("========================================");
        }

        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
            needle = -1;
            System.out.println("========================================");
        }

        //    @Ignore ("not ready")
        @Test
        public void testFailRecursive1(){
            int resultTrue = -1;
            int test = p58_1_1_22.binaryRecursiveSearch(p58_1_1_22_test._array, needle);
            assertEquals(resultTrue,test);
            System.out.println("@Test - testFailRecursive1: needle="+needle+"; result="+resultTrue);
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
}
