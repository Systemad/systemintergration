package controllers;


import java.util.ArrayList;
import java.util.List;
import models.temperature;
import models.Response;
import org.springframework.web.bind.annotation.*;
import repositories.temperatureDAO;

@RestController
public class temperatureController {

    temperatureDAO temperatureDAO = new temperatureDAO();

    List<temperature> temperatureList = new temperatureDAO().getTemperature();

    @RequestMapping("/temperatures")
    public List<temperature> index() {
        return temperatureDAO.getTemperature();
    }

    @RequestMapping("/temperature/{id}")
    public temperature getTempById(@PathVariable int id){
        temperature res = new temperature();
        for(temperature t : temperatureList){
            if(t.getId() == id){
                res = t;
            }
        }
        return res;
    }

    @RequestMapping("/booksBetween/{idFrom}/{idTo}")
    public List<temperature> getBooksBetween(@PathVariable int idFrom, @PathVariable int idTo){
        List<temperature> res = new ArrayList();
        for (temperature t : temperatureList){
            int id = t.getId();
            if (id >= idFrom && id <= idTo){
                res.add(t);
            }
        }
        return res;
    }

    @RequestMapping("/temperature/{id}/delete")
    public Response deleteBookById(@PathVariable("id") int id) {
        Response res = new Response("Book Deleted", Boolean.FALSE);

        int indexToRemove = -1;
        for (int i = 0; i < temperatureList.size(); i++) {
            if (temperatureList.get(i).getId() == id) {
                indexToRemove = i;
            }
        }
        if (indexToRemove != -1) {
            temperatureList.remove(indexToRemove);
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }

    @PostMapping("/temperature/add")
    public Response addBook(@RequestBody temperature b){
        System.out.println(b.getId()+" "+b.getTemperature()+" "+b.getHumidity() + "" + b.getLum());
        Response res = new Response("Book added", Boolean.FALSE);
        temperatureList.add(b);
        res.setStatus(Boolean.TRUE);
        return res;
    }

}


