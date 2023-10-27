package ru.croc.barkhatnat.homework3.task5.intefaces;

import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;
import ru.croc.barkhatnat.homework3.task5.exceptions.NotImportHouseholdAppliance;

import java.util.ArrayList;

public interface IHouseholdAppliance {
    public double getPrice();
    public void setPrice(double price);
    public String getDescription();
    public void setDescription(String description);
    public ArrayList<Float> getSize();
    public void setSize(ArrayList<Float> size) throws BadSizeException;
    public float getPower();
    public void setPower(float power);
    public boolean isImported();
    public int getWarrantyPeriod();
    public String getCountryOfOrigin();
    public void setWarrantyPeriod(int warrantyPeriod);
    public void setCountryOfOrigin(String countryOfOrigin) ;
    public String getCountryOfManufacture();
    public boolean hasManufacturerWarranty() throws NotImportHouseholdAppliance;
}
