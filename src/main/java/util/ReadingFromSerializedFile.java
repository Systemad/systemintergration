package util;
import java.util.ArrayList;
import java.util.List;

import restdemospring.models.Book;


public class ReadingFromSerializedFile {
    SerializationManager sm = new SerializationManager();
    List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        SerializationManager sm = new SerializationManager();
        List<Book> bookList = new ArrayList<>();

        bookList = (List<Book>)sm.deSerializeList("src/main/java/restdemospring/allbooks2.ser");
        bookList.forEach(b -> System.out.println(b.getName()));

    }
}
