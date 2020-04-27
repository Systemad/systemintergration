package Clients;

import Models.Response;
import org.springframework.web.client.RestTemplate;
import Models.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONClient {

    private static Book getBook(){
        final String uri = "http://localhost:8080/book.json";
        RestTemplate restTemplate = new RestTemplate();
        Book result = restTemplate.getForObject(uri, Book.class);
        System.out.println(result.getName()+" by "+result.getAuthor());
        return result;
    }

    public static void main(String[] args) {
        getBook();
    }
}
