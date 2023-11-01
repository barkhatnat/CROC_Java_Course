package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IRobotVacuumCleaner;

public abstract class RobotVacuumCleaner extends HouseholdAppliance implements IRobotVacuumCleaner {

    private int batteryLife;


    public RobotVacuumCleaner(double price, String description, Dimensions size, float power, int batteryLife, int warrantyPeriod, String countryOfOrigin) {
        super(price, description, size, power, warrantyPeriod, countryOfOrigin);
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() {
        return batteryLife;
    }


    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

}
