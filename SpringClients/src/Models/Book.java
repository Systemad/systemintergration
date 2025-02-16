package Models;


import java.io.Serializable;

public class Book implements Serializable {

    private String name;
    private String author;
    private int id;

    public Book(){}

    public Book(String name, String author, int id) {
        this.name = name;
        this.author = author;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
