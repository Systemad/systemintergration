package restdemospring.models;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private int phone;
    private int id;

    public Person(){}

    public Person(String name, int phone, int id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
