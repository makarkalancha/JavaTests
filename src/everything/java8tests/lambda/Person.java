package everything.java8tests.lambda;

import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * User: Makar Kalancha
 * Date: 02/09/14
 * Time: 10:17 AM
 */
public class Person {
    public enum Sex{
        MALE,FEMALE
    }

    public Person(String name,LocalDate birthday, Sex gender, String emailAddress){
        this._name = name;
        this._birthday = birthday;
        this._gender = gender;
        this._emailAddress = emailAddress;
    }

    private String _name;
    private LocalDate _birthday;
    private Sex _gender;
    private String _emailAddress;

    public String getName() {
        return _name;
    }

    public LocalDate getBirthday() {
        return _birthday;
    }

    public Sex getGender() {
        return _gender;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public int getAge() {
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(_birthday, now);
        return age.getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "_name='" + _name + '\'' +
                ", _birthday=" + _birthday +
                ", _age=" + getAge() +
                ", _gender=" + _gender +
                ", _emailAddress='" + _emailAddress + '\'' +
                '}';
    }
}
