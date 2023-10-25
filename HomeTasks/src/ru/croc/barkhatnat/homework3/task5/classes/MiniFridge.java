package ru.croc.barkhatnat.homework3.task5.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IFridge;

import java.util.ArrayList;

public class MiniFridge implements IFridge {
    private double price;
    private String description;
    private ArrayList<Float> size;
    private float power;

    public MiniFridge(double price, String description, ArrayList<Float> size, float power) {
        this.price = price;
        this.description = description;
        this.size = size;
        this.power = power;
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
        return hasFreezer;
    }
    public String getType() {
        return "Mini fridge";
    }
    @Override
    public String toString() {
        return String.format("Type: %s\nPrice: %s\u20bd \nDescription: %s\nSize: %sm \u00d7 %sm \u00d7 %sm \nPower: %sW\n",
                getType(), price, description, size.get(0), size.get(1), size.get(2), power);
    }
}
