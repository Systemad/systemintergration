package util;

import com.google.gson.Gson;
import restdemospring.models.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateJSONFile {

    Gson gson = new Gson();
    List<Book> bookList = new ArrayList<>();

    CreateJSONFile(){
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

        String json = gson.toJson(bookList);

        try(FileWriter writer = new FileWriter("src/main/java/restdemospring/allbooksJSON.json");){
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        CreateJSONFile cr = new CreateJSONFile();
    }
}

