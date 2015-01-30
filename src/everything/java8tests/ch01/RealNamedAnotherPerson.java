package everything.java8tests.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 17:06
 */
public class RealNamedAnotherPerson implements Person, NamedAnother {
    private long id;
    private String name;

    public RealNamedAnotherPerson(long id) {
        this.id = id;
    }

    public RealNamedAnotherPerson(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        if (name == null) {
            return Person.super.getName();
        }

        return name;
    }
}
