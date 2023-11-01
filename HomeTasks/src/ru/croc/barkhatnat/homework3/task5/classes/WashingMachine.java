package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IWashingMachine;


public abstract class WashingMachine extends HouseholdAppliance implements IWashingMachine {
    private int maxLoad;

    public WashingMachine(double price, String description, Dimensions size, float power, int maxLoad, int warrantyPeriod, String countryOfOrigin) {
        super(price, description, size, power, warrantyPeriod, countryOfOrigin);
        this.maxLoad = maxLoad;
    }


    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }
}
