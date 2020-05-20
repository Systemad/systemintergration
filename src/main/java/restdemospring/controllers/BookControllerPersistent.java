package restdemospring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import restdemospring.models.Book;
import restdemospring.models.Response;
import restdemospring.repositories.*;

import java.util.ArrayList;
import java.util.List;
public class BookControllerPersistent {

    //IBookDAO bookDao = new BookDaoSerPersistent();
    IBookDAO bookDao = new BookDaoJSONPersistent();
    List<Book> bookList = bookDao.getAllBooks();

    @RequestMapping("/per/books")
    //@RequestMapping(value = "/books", produces = MediaType.TEXT_XML_VALUE, method = RequestMethod.GET)
    public List<Book> index() {
        return bookList;
    }

    @RequestMapping("/per/book")
    public Book oneBook() {
        return new Book("Avalons dimmor", "Bradley Zimmer", 10);
    }

    @RequestMapping("/per/booksHTML")
    public String getBooksHTML(){
        String res = "<HTML><HEAD><TITLE>Books</TITLE></HEAD><BODY><TABLE>";
        for (Book b : bookList){
            res += "<TR><TD>"+b.getId()+"</TD><TD>"+b.getAuthor()+"</TD><TD>"+b.getName()+"</TD></TR>";
        }
        res += "</TABLE></HTML>";
        return res;
    }

    @RequestMapping("/per/book/{id}")
    public Book getBookById(@PathVariable int id){
        System.out.println("hej");
        Book res = new Book();
        for (Book b : bookList){
            if (b.getId() == id){
                res = b;
            }
        }
        return res;
    }

    @RequestMapping("/per/booksBetween/{idFrom}/{idTo}")
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

    @RequestMapping("/per/book/{id}/delete")
    public Response deleteBookById(@PathVariable("id") int id){
        Response res = new Response("Book deleted", Boolean.FALSE);

        int indexToRemove = -1;
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getId() == id){
                indexToRemove = i;
            }
        }

        if (indexToRemove != -1){
            bookList.remove(indexToRemove);
            res.setStatus(Boolean.TRUE);
        }
        bookDao.persistBooks(bookList);
        return res;
    }


    @PostMapping("/per/book/add")
    public Response addBook(@RequestBody Book b){
        System.out.println(b.getId()+" "+b.getAuthor()+" "+b.getName());
        Response res = new Response("Book added", Boolean.FALSE);
        bookList.add(b);
        res.setStatus(Boolean.TRUE);
        bookDao.persistBooks(bookList);
        return res;
    }

    @PostMapping("/per/book/update")
    public Response upsertBook(@RequestBody Book b){
        Response res = new Response("Book updated", Boolean.FALSE);

        int indexToUpdate = -1;
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getId() == b.getId()){
                indexToUpdate = i;
            }
        }

        if (indexToUpdate == -1){
            bookList.add(b);
            res.setMessage("Book inserted");
            res.setStatus(Boolean.TRUE);
        }
        else{
            bookList.set(indexToUpdate, b);
            res.setStatus(Boolean.TRUE);
        }
        bookDao.persistBooks(bookList);
        return res;
    }
}