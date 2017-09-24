package everything.validation.entity;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 15:47
 */
public class Professor {
    private final String lastName;
    private final String departmentName;
    private final String officeNumber;

    public Professor(String lastName, String departmentName, String officeNumber) {
        this.lastName = lastName;
        this.departmentName = departmentName;
        this.officeNumber = officeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "lastName='" + lastName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                '}';
    }
}
