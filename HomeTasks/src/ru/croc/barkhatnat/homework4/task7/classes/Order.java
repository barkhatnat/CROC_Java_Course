package ru.croc.barkhatnat.homework4.task7.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;
import ru.croc.barkhatnat.homework4.task7.enums.OrderStatus;
import ru.croc.barkhatnat.homework4.task7.exceptions.BadListOrderSizeException;
import ru.croc.barkhatnat.homework4.task7.exceptions.OrderStatusException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private final String id;
    private final LocalDateTime createDateTime;
    private LocalDateTime collectedDateTime;
    private LocalDateTime closedDateTime;
    private final ArrayList<IHouseholdAppliance> listOfItems;
    private final Client client;
    private OrderStatus orderStatus;
    private final Notificator notificator = new Notificator(this);

    public Order(ArrayList<IHouseholdAppliance> listOfItems, Client client, LocalDateTime createDateTime) throws BadListOrderSizeException {
        int listOfItemsLength = listOfItems.size();
        if (listOfItemsLength > 0 && listOfItemsLength <= 75) {
            this.listOfItems = listOfItems;
        } else {
            throw new BadListOrderSizeException("Order list can't be empty or contain more than 75 items");
        }
        this.createDateTime = createDateTime;
        this.client = client;
        id = createId();
        orderStatus = OrderStatus.CREATED;
    }

    private String createId() {
        return String.format("%ty%tm%td%tH%tM%tS%s", createDateTime, createDateTime, createDateTime, createDateTime,
                createDateTime, createDateTime, client.getPhoneNumber().substring(6));
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        double amount = 0;
        for (IHouseholdAppliance item : listOfItems) {
            amount += item.getPrice();
        }
        return amount;
    }

    public void collectOrder() {
        orderStatus = OrderStatus.COLLECTED;
        collectedDateTime = LocalDateTime.now();
    }

    public String getOrderNotification() throws OrderStatusException {
        if (orderStatus.equals(OrderStatus.COLLECTED)) {
            return notificator.getNotification();
        } else {
            throw new OrderStatusException("Current status is " +
                    orderStatus + " ,must be " + OrderStatus.COLLECTED);
        }

    }

    public void issueOrder() {
        orderStatus = OrderStatus.CLOSED;
        closedDateTime = LocalDateTime.now();
    }

    public void writeOffOrder() {
        orderStatus = OrderStatus.EXPIRED;
        closedDateTime = LocalDateTime.now();
    }

    public boolean checkAndSetExpirationStatus() throws OrderStatusException {
        if (orderStatus.equals(OrderStatus.COLLECTED)) {
            Duration duration = Duration.between(LocalDateTime.now(), collectedDateTime.plusWeeks(2));
            boolean isStorageExpired = duration.isNegative() || duration.isZero();
            if (isStorageExpired) {
                writeOffOrder();
            }
            return isStorageExpired;
        } else {
            throw new OrderStatusException("The order has unsuitable status. Current status is " +
                    orderStatus + " ,must be " + OrderStatus.COLLECTED);
        }

    }

    public void closeOrder() {
        orderStatus = OrderStatus.CLOSED;
    }

    public boolean canReceiveOrder() throws OrderStatusException {
        if (orderStatus.equals(OrderStatus.CREATED)) {
            return false;
        } else if (orderStatus.equals(OrderStatus.COLLECTED) && !checkAndSetExpirationStatus()) {
            return true;
        } else {
            throw new OrderStatusException("The order is closed: it may be expired or received");
        }
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public LocalDateTime getCollectedDateTime() {
        return collectedDateTime;
    }

    public LocalDateTime getClosedDateTime() {
        return closedDateTime;
    }


    public Client getClient() {
        return client;
    }


    public ArrayList<IHouseholdAppliance> getListOfItems() {
        return listOfItems;
    }

}
