package com.everything.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcalancea on 2015-12-22.
 */
public class ListRemove {

    private static class Student{
        private int id;
        private String firstName;
        private String lastName;
        public Student(int i, String f, String l){
            this.id = i;
            this.firstName = f;
            this.lastName = l;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", firstName=" + firstName +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student one = new Student(1, "John", "Doe");
        Student two = new Student(2, "Jessica", "Beal");
        Student three = new Student(3, "Kevin", "Smith");

        List<Student> students = new ArrayList<>();
        students.add(one);
        students.add(two);
        students.add(three);
        final List<Integer> numbers = Arrays.asList(2, 4, 1); //immutable list
        System.out.println(students);
        System.out.println(numbers);

        students.remove(new Student(2, "Jessica", "Beal"));
        numbers.remove(2);

//        students.removeIf(student -> numbers.contains(student.getId()));
////        Iterator<Student> studentIterator = students.iterator();
////        while(studentIterator.hasNext()) {
////            Student student = studentIterator.next();
////            if(numbers.contains(student.getId())){
////                studentIterator.remove();
////            }
////        }
        System.out.println(students);
        System.out.println(numbers);
    }
}
