package util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import restdemospring.models.Book;

public class SerializationManager {

    public void serializeList(List<Book> list, String filePath ){
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {

            objectOut.writeObject(list);
            System.out.printf("Books saved in i %s\n", filePath);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> deSerializeList(String filePath){
        System.out.println("deSerializeList "+filePath);
        List<Book> list = new ArrayList<Book>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn);) {

            list = (List<Book>) in.readObject();
            System.out.println("deserialize" + list.size()+ " books");
            return list;
        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Book unkown class");
        }
        return list;
    }
}
