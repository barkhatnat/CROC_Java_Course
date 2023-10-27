package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;

import java.util.ArrayList;

public class FreezerFridge extends Fridge {
    private float freezerTemperature;

    public FreezerFridge(double price, String description, ArrayList<Float> size, float power, float temperature, float freezerTemperature,int warrantyPeriod, String countryOfOrigin) throws BadSizeException {
        super(price, description, size, power, temperature, warrantyPeriod, countryOfOrigin);
        this.freezerTemperature = freezerTemperature;
    }

    public float getFreezerTemperature() {
        return freezerTemperature;
    }

    public void setFreezerTemperature(float freezerTemperature) {
        this.freezerTemperature = freezerTemperature;
    }

    public String getType() {
        return "Fridge with freeze";
    }


    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nTemperature: %s\u00b0 \nFreezer temperature: %s\u00b0\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().get(0), this.getSize().get(1), this.getSize().get(2), this.getPower(), this.getTemperature(), this.getFreezerTemperature(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}
