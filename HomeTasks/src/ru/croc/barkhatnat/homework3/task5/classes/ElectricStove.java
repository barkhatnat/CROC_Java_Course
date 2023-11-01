package ru.croc.barkhatnat.homework3.task5.classes;


public class ElectricStove extends KitchenStove {

    public ElectricStove(double price, String description, Dimensions size, float power, float temperature,int warrantyPeriod, String countryOfOrigin)  {
        super(price, description, size, power, temperature,warrantyPeriod,countryOfOrigin);
    }

    public String getType() {
        return "Electric Stove";
    }

}
