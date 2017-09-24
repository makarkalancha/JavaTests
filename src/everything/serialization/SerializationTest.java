package everything.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Makar Kalancha
 * Date: 30 Aug 2017
 * Time: 16:04
 */
public class SerializationTest {
    private static String FILE_NAME = "serializedStudent.data";

    public static void main(String[] args) {
        Student student1 = new Student("John1", new Address("street1", "city1"));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(student1);
        }catch (FileNotFoundException e){
            System.err.println("cannot create a file with the given file name");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("an I/O error occurred while processing the file");
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            Student studentNew = (Student) ois.readObject();
            System.out.println(studentNew);
        }catch (FileNotFoundException e){
            System.err.println("cannot create a file with the given file name");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("an I/O error occurred while processing the file");
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.err.println("cannot recognize the class of the object - is the file corrupted?");
            e.printStackTrace();
        }
    }
}
