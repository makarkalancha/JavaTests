package everything.jaxbtest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by mcalancea on 2015-04-23.
 */
@XmlRootElement(name = "book")
//@XmlType(propOrder = {"author","name","publisher","isbn","objectClassName"})
@XmlType(propOrder = {"author","name","publisher","isbn"})
public class Book {
    private static class ErroneousObjectWrapper{
        private String objectClassName;
        public ErroneousObjectWrapper(Object obj) {
            this.objectClassName = obj.getClass().getCanonicalName();
        }

        public String getObjectClassName() {
            return objectClassName;
        }

        public void setObjectClassName(String objectClassName) {
            this.objectClassName = objectClassName;
        }
    }
    @XmlTransient
    private ErroneousObjectWrapper erroneousObjectWrapper;

    private String name;
    private String author;
    private String publisher;
    private String isbn;

//    private String objectClassName;

    public Book(){
    }

//    public Book(Object object) {
//        this.objectClassName = object.getClass().getCanonicalName();
//    }

    //in xml-output title
    @XmlElement(name="title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getErroneousObjectFullClassName() {
        return erroneousObjectWrapper.getObjectClassName();
    }

    public void setErroneousObjectWrapper(Object erroneousObject) {
        this.erroneousObjectWrapper = new ErroneousObjectWrapper(erroneousObject);
    }

//    public String getObjectClassName() {
//        return objectClassName;
//    }

//    public void setObjectClassName(Object object) {
//        this.objectClassName = object.getClass().getCanonicalName();
//    }

//    public void setObjectClassName(String objectClassName) {
//        this.objectClassName = objectClassName;
//    }
}
