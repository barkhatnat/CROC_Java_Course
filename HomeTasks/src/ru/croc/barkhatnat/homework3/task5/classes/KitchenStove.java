package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IKitchenStove;

public abstract class KitchenStove extends HouseholdAppliance implements IKitchenStove {

    private float ovenTemperature;

    public KitchenStove(double price, String description, Dimensions size, float power, float ovenTemperature, int warrantyPeriod, String countryOfOrigin) {
        super(price, description, size, power, warrantyPeriod, countryOfOrigin);
        this.ovenTemperature = ovenTemperature;
    }


    public float getOvenTemperature() {
        return ovenTemperature;
    }

    public void setOvenTemperature(float ovenTemperature) {
        this.ovenTemperature = ovenTemperature;
    }

    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nOven temperature: %s\u00b0\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().width(), this.getSize().height(), this.getSize().deep(), this.getPower(), this.getOvenTemperature(), this.getWarrantyPeriod(), getCountryOfOrigin());
    }
}
