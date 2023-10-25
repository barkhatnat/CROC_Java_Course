package ru.croc.barkhatnat.homework3.task5.intefaces;

import java.util.ArrayList;

public interface IHouseholdAppliance {
    public double getPrice();
    public void setPrice(double price);
    public String getDescription();
    public void setDescription(String description);
    public ArrayList<Float> getSize();
    public void setSize(ArrayList<Float> size);
    public float getPower();
    public void setPower(float power);
}
