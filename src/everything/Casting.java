package everything;

/**
 * User: Makar Kalancha
 * Date: 14/11/13
 * Time: 11:06 AM
 */
public class Casting {

    public static void main(String[] args){
        A a1 = new A();
        a1.doSmth();
        A ab1 = new B();
        ab1.doSmth();

//        everything.B b1 = (everything.B) a1;
        B b1 = (B) ab1;
        b1.doSmth();
    }
}

class A{
    int a = 10;
    public void doSmth(){
        System.out.println("a");
    }
}

class B extends A{
    int b= 20;
    public void doSmth(){
        System.out.println("b");
    }
}
