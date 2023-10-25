package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IFreezer;
import ru.croc.barkhatnat.homework3.task5.intefaces.IFridge;

import java.util.ArrayList;

public class FreezerFridge implements IFreezer, IFridge {
    private double price;
    private String description;
    private ArrayList<Float> size;
    private float power;
    private float freezerTemperature;

    public FreezerFridge(double price, String description, ArrayList<Float> size, float power, float freezerTemperature) {
        this.price = price;
        this.description = description;
        this.size = size;
        this.power = power;
        this.freezerTemperature = freezerTemperature;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ArrayList<Float> getSize() {
        return size;
    }

    @Override
    public void setSize(ArrayList<Float> size) {
        this.size = size;
    }

    @Override
    public float getPower() {
        return power;
    }

    @Override
    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public boolean getHasFreezer() {
        return true;
    }

    @Override
    public float getFreezerTemperature() {
        return freezerTemperature;
    }

    @Override
    public void setFreezerTemperature(float freezerTemperature) {
        this.freezerTemperature = freezerTemperature;
    }

    public String getType() {
        return "Fridge with freeze";
    }

    @Override
    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\nOven temperature: %s\u00b0\n",
                getType(), price, description, size.get(0), size.get(1), size.get(2), power, freezerTemperature);
    }

}
