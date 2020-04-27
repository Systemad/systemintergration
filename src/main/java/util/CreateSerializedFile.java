package util;
import java.util.ArrayList;
import java.util.List;

import restdemospring.models.Book;

public class CreateSerializedFile {

    SerializationManager sm = new SerializationManager();
    List<Book> bookList = new ArrayList<>();

    CreateSerializedFile(){
        Book b1 = new Book("Wuthering Heights", "Emily Bronte", 1);
        Book b2 = new Book("Jayne Eyre", "Charlotte Bronte", 2);
        Book b3 = new Book("Crime and Punishment", "Fjodor Dostovjevsky", 3);
        Book b4 = new Book("Madame Bovary", "Gustave Flaubert", 4);
        Book b5 = new Book("Catcher in the Rye", "J.D. Salinger", 5);
        Book b6 = new Book("Pale King", "David Foster Wallace", 6);
        Book b7 = new Book("Sandman, vol 1", "Neil Gaiman", 7);

        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
        bookList.add(b7);

        sm.serializeList(bookList, "src/main/java/restdemospring/allbooks1.ser");
    }

    public static void main(String[] args) {
        CreateSerializedFile c = new CreateSerializedFile();
    }
}
