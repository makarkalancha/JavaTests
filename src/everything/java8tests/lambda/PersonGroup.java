package everything.java8tests.lambda;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Makar Kalancha
 * Date: 05 Oct 2016
 * Time: 14:56
 */
public class PersonGroup {
    private final Set<Person> persons;
    private final Long id;

    public PersonGroup(Long id, Set<Person> persons) {
        this.id = id;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public Set<Person> getPersons() {
        return new HashSet<>(persons);
    }
}
