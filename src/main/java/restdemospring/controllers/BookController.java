package restdemospring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restdemospring.models.*;
import restdemospring.repositories.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    BookDAO bookDAO = new BookDAO();
    List<Book> bookList = new BookDAO().getAllBooks();

    @RequestMapping(value = "/bookjson", headers = "Accept=application/json")
    public Book OneBookJson(){
        return new Book("Test Title", "Title Author", 5);
    }

    @RequestMapping(value = "/bookxml", produces = "application/xml")
    public Book OneBookXML(){
        return new Book("XML title", "XML author", 1);
    }


    @RequestMapping("/books")
    public List<Book> index(){
        return bookDAO.getAllBooks();
    }

    @RequestMapping("/book/{id}")
    public Book getBookById(@PathVariable int id){
        Book res = new Book();
        for (Book b : bookList){
            if (b.getId() == id){
                res = b;
            }
        }
        return res;
    }

    @RequestMapping("/booksBetween/{idFrom}/{idTo}")
    public List<Book> getBooksBetween(@PathVariable int idFrom, @PathVariable int idTo){
        List<Book> res = new ArrayList();
        for (Book b : bookList){
            int id = b.getId();
            if (id >= idFrom && id <= idTo){
                res.add(b);
            }
        }
        return res;
    }
}
