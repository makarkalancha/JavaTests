package everything.java8tests.forimpatient.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 17:16
 */
public class PersonClass {
    private long id;
    private String name;
    protected int age;

    public PersonClass(long id) {
        this.id = id;
    }

    public PersonClass(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
