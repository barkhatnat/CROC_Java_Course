package ru.croc.barkhatnat.homework3.task5.classes;

public class FreezerFridge extends Fridge {
    private float freezerTemperature;

    public FreezerFridge(double price, String description, Dimensions size, float power, float temperature, float freezerTemperature, int warrantyPeriod, String countryOfOrigin)  {
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
                getType(), this.getPrice(), this.getDescription(), this.getSize().width(), this.getSize().height(), this.getSize().deep(), this.getPower(), this.getTemperature(), this.getFreezerTemperature(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}
