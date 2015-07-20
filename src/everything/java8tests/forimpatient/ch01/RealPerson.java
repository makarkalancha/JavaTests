package everything.java8tests.forimpatient.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 16:57
 */
public class RealPerson implements Person {
    private long id;
    private String name;

    public RealPerson(long id) {
        this.id = id;
    }

    public RealPerson(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        if(name == null) {
            return Person.super.getName();
        }
        return name;
    }
}
