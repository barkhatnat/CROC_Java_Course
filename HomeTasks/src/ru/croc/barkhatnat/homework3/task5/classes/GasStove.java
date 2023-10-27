package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;
import ru.croc.barkhatnat.homework3.task5.intefaces.IKitchenStove;

import java.util.ArrayList;

public class GasStove extends KitchenStove {

    public GasStove(double price, String description, ArrayList<Float> size, float power, float temperature,int warrantyPeriod, String countryOfOrigin) throws BadSizeException {
        super(price, description, size, power, temperature,  warrantyPeriod, countryOfOrigin);
    }
    public String getType() {
        return "Gas Stove";
    }

}
