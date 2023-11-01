package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IFridge;

public abstract class Fridge extends HouseholdAppliance implements IFridge {
    private float temperature;
    public Fridge(double price, String description, Dimensions size, float power, float temperature, int warrantyPeriod, String countryOfOrigin)  {
        super(price, description, size, power, warrantyPeriod, countryOfOrigin);
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }


    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

}
