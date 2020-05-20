package Clients;

import Models.Response;
import org.springframework.web.client.RestTemplate;
import Models.Book;

import repositories.BookDAOJSONPersistent;
import java.util.*;

public class JSONClient {

    /*
    * One Book, doesn't work for now
    private static Book getBook(){
        final String uri = "http://localhost:8080/book.json";
        RestTemplate restTemplate = new RestTemplate();
        Book result = restTemplate.getForObject(uri, Book.class);
        System.out.println(result.getName()+" by "+result.getAuthor());
        return result;
    }
    */
    private static Book getBookById(int id){
        final String uri = "http://localhost:8080/book/{id}";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        Book result = restTemplate.getForObject(uri, Book.class, params);
        System.out.println(result.getName()+" by "+result.getAuthor());
        return result;
    }

    private static List<Book> getBooks(){
        final String uri = "http://localhost:8080/books.json";
        RestTemplate restTemplate = new RestTemplate();
        Book[] resultArray = restTemplate.getForObject(uri, Book[].class);
        List<Book> result = Arrays.asList(resultArray);
        for (Book b : result){
            System.out.println(b.getName()+" by "+b.getAuthor());
        }
        return result;
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
        //getBooks();

        //getBookById(99);
        //createBook("hej", "Hej", 99);

        Scanner sc = new Scanner(System.in);

        Scanner bc = new Scanner(System.in);

        System.out.println("choose an option");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                //getBook();
                System.out.println("Hello");
                break;
            case 2:
                getBooks();
                break;
            case 3:
                System.out.println("Title: ");
                String title = bc.nextLine();

                System.out.println("Author: ");
                String auth = bc.nextLine();

                System.out.println("Id: ");
                int id = bc.nextInt();

                createBook(title,auth,id);
                getBooks();
                break;
        }
    }
}
