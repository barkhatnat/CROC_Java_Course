package ru.croc.barkhatnat.homework4.task7.interfaces;

import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;
import ru.croc.barkhatnat.homework4.task7.classes.Client;
import ru.croc.barkhatnat.homework4.task7.exceptions.OrderStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface OrderInterface {
    public String getId();

    public String getFormattedAmount();

    public void collectOrder() throws OrderStatusException;

    public String getOrderNotification() throws OrderStatusException;


    public boolean checkAndSetExpirationStatus();

    public void issueOrder() throws OrderStatusException;

    public boolean canReceiveOrder() throws OrderStatusException;

    public LocalDateTime getCreateDateTime();

    public LocalDateTime getCollectedDateTime();

    public LocalDateTime getClosedDateTime();

    public Client getClient();

    public ArrayList<IHouseholdAppliance> getListOfItems();

}

