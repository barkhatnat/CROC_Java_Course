package ru.croc.barkhatnat.homework3.task5.classes;


import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;

import java.util.ArrayList;

public class ElectricStove extends KitchenStove {

    public ElectricStove(double price, String description, ArrayList<Float> size, float power, float temperature,int warrantyPeriod, String countryOfOrigin) throws BadSizeException {
        super(price, description, size, power, temperature,warrantyPeriod,countryOfOrigin);
    }

    public String getType() {
        return "Electric Stove";
    }

}
