package restdemospring.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.catalina.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restdemospring.models.*;
import restdemospring.repositories.*;
import util.SerializationManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {


    BookDAO bookDAO = new BookDAO();
    SerializationManager sm = new SerializationManager();
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

    // Read from JSON file

    @RequestMapping("/booksjson")
    public List<Book> bookJson(){
        List<Book> bookList = new ArrayList<Book>();
        String json = new String();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/restdemospring/allbooksJSON.json"))){
            Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
            //Book book = new Gson().fromJson(br, Book.class);
            bookList = new Gson().fromJson(br, listType);
            System.out.println("book info" + bookList);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bookList;
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

    @RequestMapping("/book/{id}/delete")
    public Response deleteBookById(@PathVariable("id") int id) {
        Response res = new Response("Book Deleted", Boolean.FALSE);

        int indexToRemove = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                indexToRemove = i;
            }
        }
        if (indexToRemove != -1) {
            bookList.remove(indexToRemove);
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }

    @PostMapping("/book/add")
    public Response addBook(@RequestBody Book b){
        System.out.println(b.getId()+" "+b.getAuthor()+" "+b.getName());
        Response res = new Response("Book added", Boolean.FALSE);
        bookList.add(b);
        res.setStatus(Boolean.TRUE);
        sm.serializeList(bookList, "src/main/java/restdemospring/allbooks2.ser");
        return res;
    }

    @PostMapping("/book/update")
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
        return res;
    }
}
