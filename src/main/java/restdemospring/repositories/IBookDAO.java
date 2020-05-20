package restdemospring.repositories;

import restdemospring.models.Book;
import java.util.List;

public interface IBookDAO {

    public List<Book> getAllBooks();
    public void persistBooks(List<Book> bookList);
}
