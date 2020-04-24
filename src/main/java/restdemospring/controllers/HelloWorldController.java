package restdemospring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/swe")
    public String indexSvenska() {
        return "Hejsan världen";
    }

    @RequestMapping("/hello")
    public String addFoo(@RequestParam String firstname, @RequestParam String lastname) {
        return "Hello " + firstname + " " + lastname;
    }

    @RequestMapping("/helloOptional")
    public String helloOptional(@RequestParam(required = false) String firstname,
                                @RequestParam(required = false) String lastname) {
        String name = "";
        if (firstname != null){
            name = firstname;
        }
        if (lastname != null){
            if (name.length() == 0) name = lastname;
            else  name += " "+lastname;
        }
        return "Hej " + name;
    }

    @RequestMapping("/helloHTML")
    public String helloHTML(@RequestParam String firstname, @RequestParam String lastname) {
        return "<H1>Hejsan " + firstname + " " + lastname+ "</h1>";
    }

    @RequestMapping("/defaultHello")
    public String defaultHello(@RequestParam(defaultValue = "dan") String name) {
        return "Hej " + name;
    }

    @RequestMapping("/listHello")
    public String listHello(@RequestParam List<String> id) {
        return "IDs are " + id;
    }

    @GetMapping("/pathvartest/{id}")
    public String pathvartest(@PathVariable String id) {
        return "ID: " + id;
    }

    // @RequestMapping("/book")
    // public Book book() {return new Book(1, "Java", "Sigrun");}

}
