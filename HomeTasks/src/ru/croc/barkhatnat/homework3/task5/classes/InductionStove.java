package ru.croc.barkhatnat.homework3.task5.classes;

public class InductionStove extends KitchenStove {

    public InductionStove(double price, String description, Dimensions size, float power, float temperature, int warrantyPeriod, String countryOfOrigin) {
        super(price, description, size, power, temperature, warrantyPeriod, countryOfOrigin);
    }

    public String getType() {
        return "Induction Stove";
    }

}
