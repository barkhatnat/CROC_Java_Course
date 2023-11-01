package ru.croc.barkhatnat.homework3.task5.intefaces;

import ru.croc.barkhatnat.homework3.task5.classes.Dimensions;
import ru.croc.barkhatnat.homework3.task5.exceptions.NotImportHouseholdAppliance;


public interface IHouseholdAppliance {
    public double getPrice();

    public void setPrice(double price);

    public String getDescription();

    public void setDescription(String description);

    public Dimensions getSize();

    public void setSize(Dimensions size);

    public float getPower();

    public void setPower(float power);

    public boolean isImported();

    public int getWarrantyPeriod();

    public String getCountryOfOrigin();

    public void setWarrantyPeriod(int warrantyPeriod);

    public void setCountryOfOrigin(String countryOfOrigin);

    public String getCountryOfManufacture();

    public boolean hasManufacturerWarranty() throws NotImportHouseholdAppliance;
}
