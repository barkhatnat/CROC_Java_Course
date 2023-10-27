package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;
import ru.croc.barkhatnat.homework3.task5.intefaces.IWashingMachine;

import java.util.ArrayList;

public class DryerWashingMachine extends WashingMachine {
    private int maxDryerLoad;

    public DryerWashingMachine(double price, String description, ArrayList<Float> size, float power, int maxLoad, int maxDryerLoad, int warrantyPeriod, String countryOfOrigin)throws BadSizeException {
        super(price, description, size, power, maxLoad,warrantyPeriod,countryOfOrigin);
        this.maxDryerLoad = maxDryerLoad;
    }

    public float getMaxDryerLoad() {
        return maxDryerLoad;
    }

    public void setMaxDryerLoad(int maxDryerLoad) {
        this.maxDryerLoad = maxDryerLoad;
    }

    public String getType() {
        return "Washing machine with dryer";
    }

    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nMaximum load: %skg\nMaximum dryer load: %skg\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().get(0), this.getSize().get(1), this.getSize().get(2), this.getPower(), this.getMaxLoad(), this.getMaxDryerLoad(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}