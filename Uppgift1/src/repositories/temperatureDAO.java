package repositories;

import java.util.ArrayList;
import java.util.List;
import models.*;


public class temperatureDAO {

    public List <temperature> getTemperature(){

        List<temperature> temperatureList = new ArrayList<>();

        temperature temp1 = new temperature(10, 21, 11, 1);
        temperature temp2 = new temperature(20, 22, 12, 2);
        temperature temp3 = new temperature(30, 23, 13, 3);
        temperature temp4 = new temperature(40, 24, 14, 4);
        temperature temp5 = new temperature(50, 25, 15, 5);
        temperature temp6 = new temperature(60, 26, 16, 6);
        temperature temp7 = new temperature(70, 27, 17, 7);

        temperatureList.add(temp1);
        temperatureList.add(temp2);
        temperatureList.add(temp3);
        temperatureList.add(temp4);
        temperatureList.add(temp5);
        temperatureList.add(temp6);
        temperatureList.add(temp7);

        return temperatureList;
    }
}
