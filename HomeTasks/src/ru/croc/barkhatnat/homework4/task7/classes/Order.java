package ru.croc.barkhatnat.homework4.task7.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;
import ru.croc.barkhatnat.homework4.task7.enums.OrderStatus;
import ru.croc.barkhatnat.homework4.task7.exceptions.BadListOrderSizeException;
import ru.croc.barkhatnat.homework4.task7.exceptions.OrderStatusException;
import ru.croc.barkhatnat.homework4.task7.interfaces.OrderInterface;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Order implements OrderInterface {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        return createDateTime.format(formatter) + client.getPhoneNumber().substring(7);
    }

    public String getId() {
        return id;
    }

    private double getAmount() {
        double amount = 0;
        for (IHouseholdAppliance item : listOfItems) {
            amount += item.getPrice();
        }
        return amount;
    }

    public String getFormattedAmount() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return currencyFormatter.format(getAmount());
    }

    public void collectOrder() throws OrderStatusException {
        if (orderStatus.equals(OrderStatus.CREATED)) {
            orderStatus = OrderStatus.COLLECTED;
            collectedDateTime = LocalDateTime.now();
        } else {
            throw new OrderStatusException("The order has unsuitable status. Current status is " +
                    orderStatus + " ,must be " + OrderStatus.COLLECTED);
        }
    }

    public String getOrderNotification() throws OrderStatusException {
        if (orderStatus.equals(OrderStatus.COLLECTED)) {
            return notificator.getNotification();
        } else {
            throw new OrderStatusException("Current status is " +
                    orderStatus + " ,must be " + OrderStatus.CREATED);
        }

    }


    private void writeOffOrder() {
        orderStatus = OrderStatus.EXPIRED;
        closedDateTime = LocalDateTime.now();
    }

    public boolean checkAndSetExpirationStatus() {
        if (orderStatus.equals(OrderStatus.COLLECTED)) {
            Duration duration = Duration.between(LocalDateTime.now(), collectedDateTime.plusWeeks(2));
            boolean isStorageExpired = duration.isNegative() || duration.isZero();
            if (isStorageExpired) {
                writeOffOrder();
                closedDateTime = LocalDateTime.now();
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public void issueOrder() throws OrderStatusException {
        if (canReceiveOrder()) {
            orderStatus = OrderStatus.CLOSED;
            closedDateTime = LocalDateTime.now();
        }
    }

    public boolean canReceiveOrder() throws OrderStatusException {
        if (orderStatus.equals(OrderStatus.CREATED)) {
            return false;
        } else if (orderStatus.equals(OrderStatus.COLLECTED) && checkAndSetExpirationStatus()) {
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
        return new ArrayList<>(listOfItems);
    }

}
