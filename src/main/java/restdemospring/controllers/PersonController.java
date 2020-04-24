package restdemospring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restdemospring.models.*;
import restdemospring.repositories.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    PersonDAO personDAO = new PersonDAO();
    List<Person> personList = new PersonDAO().getAllPersons();

    @RequestMapping("/person")
    public List<Person> index(){
        return personList;
    }

    @RequestMapping("/person/{id}")
    public Person getBookById(@PathVariable int id){
        Person res = new Person();
        for (Person b : personList){
            if (b.getId() == id){
                res = b;
            }
        }
        return res;
    }

    @RequestMapping("/personBetween/{idFrom}/{idTo}")
    public List<Person> getPersonBetween(@PathVariable int idFrom, @PathVariable int idTo){
        List<Person> res = new ArrayList();
        for (Person b : personList){
            int id = b.getId();
            if (id >= idFrom && id <= idTo){
                res.add(b);
            }
        }
        return res;
    }
}
