package everything.java8tests.ch01;

import java.nio.file.Paths;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 17:17
 */
public class Student extends PersonClass implements Named {

    public Student(long id) {
        super(id);
    }

    public Student(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id:"+this.getId()+";"+
                "name:"+this.getName()+";"+
                "age:"+this.getAge()+";"+
                "}";
    }
}
