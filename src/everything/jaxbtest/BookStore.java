package everything.jaxbtest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcalancea on 2015-04-23.
 */
//root element
@XmlRootElement(namespace = "everything.jaxbtest")
public class BookStore {


//    private List<Book> bookList;
    private ArrayList<Book> bookList;
    private String name;
    private String location;

    //wrapper
    @XmlElementWrapper(name="bookList")
    //name of entities
    @XmlElement(name="book")
//    public List<Book> getBookList() {
    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

//    public void setBookList(List<Book> bookList) {
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
