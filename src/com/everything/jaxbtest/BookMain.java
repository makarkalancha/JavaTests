package com.everything.jaxbtest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mcalancea on 2015-04-23.
 */
public class BookMain {
    private static final String BOOKSTORE_XML = "bookstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        ArrayList<Book> books = new ArrayList<>();

//        Book book1 = new Book(new ArrayList<>());
        Book book1 = new Book();
        book1.setIsbn("978-0060554736");
        book1.setName("The Game");
        book1.setAuthor("Neil Strauss");
        book1.setPublisher("Harpercollins");
        books.add(book1);

//        Book book2 = new Book(new BookStore());
        Book book2 = new Book();
        book2.setIsbn("978-3832180577");
        book2.setName("Feuchtgebiete");
        book2.setAuthor("Charlotte Roche");
        book2.setPublisher("Dumont Buchverlag");
        books.add(book2);

        BookStore bookStore = new BookStore();
        bookStore.setName("Fraport Bookstore");
        bookStore.setLocation("Frankfurt Airport");
        bookStore.setBookList(books);

        JAXBContext context = JAXBContext.newInstance(com.everything.jaxbtest.BookStore.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //write to system.out
        marshaller.marshal(bookStore, System.out);

        //write to file
        marshaller.marshal(bookStore, new File(BOOKSTORE_XML));


//        JAXBContext context = JAXBContext.newInstance(Book.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//        //write to system.out
//        marshaller.marshal(book1, System.out);
//
//        //write to file
//        marshaller.marshal(book1, new File(BOOKSTORE_XML));

    }
}
