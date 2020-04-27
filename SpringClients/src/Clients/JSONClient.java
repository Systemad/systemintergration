package Clients;

import Models.Response;
import org.springframework.web.client.RestTemplate;
import Models.Book;

import java.util.*;

public class JSONClient {

    private static Book getBook(){
        final String uri = "http://localhost:8080/book.json";
        RestTemplate restTemplate = new RestTemplate();
        Book result = restTemplate.getForObject(uri, Book.class);
        System.out.println(result.getName()+" by "+result.getAuthor());
        return result;
    }

    private static List<Book> getBooks(){
        final String uri = "http://localhost:8080/book.json";
        RestTemplate restTemplate = new RestTemplate();
        Book[] resultArray = restTemplate.getForObject(uri, Book[].class);
        List<Book> result = Arrays.asList(resultArray);
        for(Book b : result){
            System.out.println(b.getName() + "" + b.getAuthor());
        }
        return  result;
    }

    private static void createBook(String title, String author, int id)
    {
        final String uri = "http://localhost:8080/book/add";
        Book newBook = new Book(title, author, id);
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.postForObject( uri, newBook, Response.class);
        System.out.println(result.getMessage());
    }

    public static void main(String[] args) {
        getBook();
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("choose an option");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getBook();
                break;
            case 2:
                getBooks();
                break;
            case 3:
                createBook("Hej", "hej", 99);
                break;
        }

         */
    }
}
