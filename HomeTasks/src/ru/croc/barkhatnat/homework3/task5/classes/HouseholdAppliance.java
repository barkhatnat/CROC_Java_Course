package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.exceptions.NotImportHouseholdAppliance;

abstract public class HouseholdAppliance {
    private double price;
    private String description;
    private Dimensions size;
    private float power;
    private int warrantyPeriod;
    private String countryOfOrigin;

    public HouseholdAppliance(double price, String description, Dimensions size, float power, int warrantyPeriod, String countryOfOrigin) {
        this.price = price;
        this.description = description;
        this.size = size;
        this.power = power;
        this.warrantyPeriod = warrantyPeriod;
        this.countryOfOrigin = countryOfOrigin;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public float getPower() {
        return power;
    }


    public void setPower(float power) {
        this.power = power;
    }

    public abstract String getType();


    public abstract String toString();

    public boolean isImported() {
        return !countryOfOrigin.equals("Russia");
    }

    public boolean hasManufacturerWarranty() throws NotImportHouseholdAppliance {
        if (isImported()) {
            return warrantyPeriod > 0;
        } else {
            throw new NotImportHouseholdAppliance("This item is not imported");
        }
    }

    public String getCountryOfManufacture() {
        if (isImported()) {
            return "Made in " + countryOfOrigin;
        } else {
            return "Made in Russia";
        }
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }


    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public Dimensions getSize() {
        return size;
    }

    public void setSize(Dimensions size) {
        this.size = size;
    }
}
