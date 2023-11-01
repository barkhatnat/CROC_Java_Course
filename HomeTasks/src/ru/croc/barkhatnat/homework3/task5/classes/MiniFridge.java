package ru.croc.barkhatnat.homework3.task5.classes;

public class MiniFridge extends Fridge {

    public MiniFridge(double price, String description, Dimensions size, float power, float temperature, int warrantyPeriod, String countryOfOrigin) {
        super(price, description, size, power, temperature, warrantyPeriod, countryOfOrigin);
    }

    public String getType() {
        return "Mini fridge";
    }

    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nTemperature: %s\u00b0\nWarranty period: %s years\nCountry: %s\n",
                getType(), this.getPrice(), this.getDescription(), this.getSize().width(), this.getSize().height(), this.getSize().deep(), this.getPower(), this.getTemperature(), this.getWarrantyPeriod(), this.getCountryOfOrigin());
    }
}
