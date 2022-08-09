package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import java.util.Map;
import java.util.TreeMap;

public class BookTest {
    public static void main(String[] args){
        Book book2 = new Book();
        book2.setTitle("book test");
        book2.setCategory("For testing purpose");
        book2.setCost(500);
        book2.addAuthor("author1");
        book2.addAuthor("author2");
        book2.setContent("test the content       process a a a a a he he method");
        book2.processContent();
        System.out.println(book2);
    }
}
