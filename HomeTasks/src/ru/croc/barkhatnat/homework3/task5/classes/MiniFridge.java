package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;

import java.util.ArrayList;

public class MiniFridge extends Fridge{

    public MiniFridge(double price, String description, ArrayList<Float> size, float power, float temperature,int warrantyPeriod, String countryOfOrigin) throws BadSizeException {
        super(price, description, size, power, temperature, warrantyPeriod, countryOfOrigin);
    }

    public String getType() {
        return "Mini fridge";
    }

    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nTemperature: %s\u00b0\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().get(0),  this.getSize().get(1),  this.getSize().get(2), this.getPower(), this.getTemperature(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}
