package restdemospring.repositories;

import restdemospring.models.*;
import java.util.ArrayList;
import java.util.List;


public class PersonDAO {

    public List<Person> getAllPersons(){

        List<Person> personList = new ArrayList<>();

        Person p1 = new Person("Person1", 11111, 1);
        Person p2 = new Person("Person2", 22222, 2);
        Person p3 = new Person("Person3", 33333, 3);
        Person p4 = new Person("Person4", 44444, 4);
        Person p5 = new Person("Person5", 55555, 5);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        return personList;
    }
}
