package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;
import ru.croc.barkhatnat.homework3.task5.exceptions.NotImportHouseholdAppliance;
import ru.croc.barkhatnat.homework3.task5.intefaces.IRobotVacuumCleaner;

import java.util.ArrayList;

public abstract class RobotVacuumCleaner implements IRobotVacuumCleaner {
    private double price;
    private String description;
    private ArrayList<Float> size;
    private float power;
    private int batteryLife;
    private int warrantyPeriod;
    private String countryOfOrigin;


    public RobotVacuumCleaner(double price, String description, ArrayList<Float> size, float power, int batteryLife,  int warrantyPeriod, String countryOfOrigin) throws BadSizeException {
        this.price = price;
        this.description = description;
        if (checkSize(size)){
            this.size = size;
        }else{
            throw new BadSizeException("Size must include 3 values");
        }
        this.power = power;
        this.batteryLife = batteryLife;
        this.warrantyPeriod = warrantyPeriod;
        this.countryOfOrigin = countryOfOrigin;
    }
    public boolean checkSize(ArrayList<Float> size){
        return size.size() == 3;
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


    public ArrayList<Float> getSize() {
        return size;
    }


    public void setSize(ArrayList<Float> size) throws BadSizeException {
        if (checkSize(size)){
            this.size = size;
        }else{
            throw new BadSizeException("Size must include 3 values");
        }
    }


    public float getPower() {
        return power;
    }


    public void setPower(float power) {
        this.power = power;
    }


    public int getBatteryLife() {
        return batteryLife;
    }


    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
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
}
