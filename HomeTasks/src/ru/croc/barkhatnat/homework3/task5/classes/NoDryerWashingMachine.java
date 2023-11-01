package ru.croc.barkhatnat.homework3.task5.classes;

public class NoDryerWashingMachine extends WashingMachine {
    public NoDryerWashingMachine(double price, String description, Dimensions size, float power, int maxLoad, int warrantyPeriod, String countryOfOrigin) {
        super(price, description, size, power, maxLoad, warrantyPeriod, countryOfOrigin);
    }

    public String getType() {
        return "Washing machine without dryer";
    }

    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nMaximum load: %skg\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().width(), this.getSize().height(), this.getSize().deep(), this.getPower(), this.getMaxLoad(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}
