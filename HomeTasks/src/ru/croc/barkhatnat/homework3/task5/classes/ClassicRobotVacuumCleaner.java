package ru.croc.barkhatnat.homework3.task5.classes;

public class ClassicRobotVacuumCleaner extends RobotVacuumCleaner {

    public ClassicRobotVacuumCleaner(double price, String description, Dimensions size, float power, int batteryLife, int warrantyPeriod, String countryOfOrigin){
        super(price, description, size, power, batteryLife, warrantyPeriod, countryOfOrigin);
    }

    public String getType() {
        return "Robot vacuum cleaner";
    }

    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nBattery life: %s hours\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().width(), this.getSize().height(), this.getSize().deep(), this.getPower(), this.getBatteryLife(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}
