package restdemospring.repositories;

import restdemospring.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

        public List<Book> getAllBooks(){

        List<Book> bookList = new ArrayList<>();

        Book b1 = new Book("Book1", "Author1", 1);
        Book b2 = new Book("Book2", "Author2", 1);
        Book b3 = new Book("Book3", "Author3", 1);
        Book b4 = new Book("Book4", "Author4", 1);
        Book b5 = new Book("Book5", "Author5", 1);
        Book b6 = new Book("Book6", "Author6", 1);
        Book b7 = new Book("Book7", "Author7", 1);

        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
        bookList.add(b7);

        return bookList;
    }
}
