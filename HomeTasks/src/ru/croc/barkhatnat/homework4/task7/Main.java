package ru.croc.barkhatnat.homework4.task7;

import ru.croc.barkhatnat.homework3.task5.classes.ClassicRobotVacuumCleaner;
import ru.croc.barkhatnat.homework3.task5.classes.InductionStove;
import ru.croc.barkhatnat.homework3.task5.classes.RobotVacuumCleaner;
import ru.croc.barkhatnat.homework3.task5.exceptions.BadSizeException;
import ru.croc.barkhatnat.homework3.task5.exceptions.NotImportHouseholdAppliance;
import ru.croc.barkhatnat.homework4.task7.classes.Client;
import ru.croc.barkhatnat.homework4.task7.classes.Order;
import ru.croc.barkhatnat.homework4.task7.exceptions.BadListOrderSizeException;
import ru.croc.barkhatnat.homework4.task7.exceptions.BadPhoneNumberException;
import ru.croc.barkhatnat.homework4.task7.exceptions.OrderStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NotImportHouseholdAppliance, BadSizeException, BadPhoneNumberException, BadListOrderSizeException, OrderStatusException {
        InductionStove inductionStove = new InductionStove(15472, "Description for InductionStove", new ArrayList<>(Arrays.asList(1f, 1.3f, 2f)), 41.8f, 280, 4, "Russia");
        RobotVacuumCleaner robotVacuumCleaner = new ClassicRobotVacuumCleaner(35421.85, "Description for RobotVacuumCleaner", new ArrayList<>(Arrays.asList(0.3f, 0.3f, 0.15f)), 42, 15, 2, "Japan");
        Client nataly = new Client("Natalia Barkhat", "88005553535", false);
        Order order = new Order(new ArrayList<>(Arrays.asList(inductionStove, robotVacuumCleaner)), nataly, LocalDateTime.now());
        order.collectOrder();
        System.out.println(order.getOrderNotification());
        System.out.println(order.canReceiveOrder());

    }
}
