package ru.croc.barkhatnat.homework3.task5;

import ru.croc.barkhatnat.homework3.task5.classes.*;
import ru.croc.barkhatnat.homework3.task5.exceptions.NotImportHouseholdAppliance;
import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NotImportHouseholdAppliance{
        InductionStove inductionStove = new InductionStove(15472, "Description for InductionStove", new Dimensions(1f, 1.3f, 2f), 41.8f, 280, 4, "Russia");
        GasStove gasStove = new GasStove(4562, "Description for GasStove",  new Dimensions(1.2f, 1.7f, 2.5f), 16.8f, 350, 1, "Korea");
        ElectricStove electricStove = new ElectricStove(8952, "Description for ElectricStove", new Dimensions(1.1f, 1.7f, 1.1f), 7.8f, 240, 7, "Russia");
        DryerWashingMachine dryerWashingMachine = new DryerWashingMachine(3112, "Description for DryerWashingMachine", new Dimensions(2f, 1.3f, 2.3f), 78.8f, 5, 4, 2, "USA");
        NoDryerWashingMachine noDryerWashingMachine = new NoDryerWashingMachine(3112, "Description for NoDryerWashingMachine", new Dimensions(2f, 2.3f, 2f), 56.8f, 6, 3, "Italy");
        MiniFridge miniFridge = new MiniFridge(7888, "Description for MiniFridge", new Dimensions(1f, 0.8f, 0.8f), 100.8f, -20, 1, "Germany");
        FreezerFridge freezerFridge = new FreezerFridge(15426, "Description for FreezerFridge", new Dimensions(1.2f, 2.8f, 1.5f), 200.8f, -20, -30, 5, "Russia");
        NoFreezerFridge noFreezerFridge = new NoFreezerFridge(10426, "Description for NoFreezerFridge", new Dimensions(1.2f, 2.5f, 1.5f), 180f, -18, 8, "China");
        RobotVacuumCleaner robotVacuumCleaner = new ClassicRobotVacuumCleaner(35421, "I wanna be your vacuum cleaner\n" +
                "Breathing in your dust\nI wanna be your Ford Cortina\nI won't ever rust\nIf you like your coffee hot\n" +
                "Let me be your coffee pot\nYou call the shots babe\nI just wanna be yours", new Dimensions(0.3f, 0.3f, 0.15f), 42, 15, 2, "Japan");
        ArrayList<IHouseholdAppliance> householdApplianceArrayList = new ArrayList<IHouseholdAppliance>(Arrays.asList(inductionStove, gasStove, electricStove,
                dryerWashingMachine, noDryerWashingMachine, miniFridge, freezerFridge, noFreezerFridge, robotVacuumCleaner));
        for (IHouseholdAppliance appliance : householdApplianceArrayList) {
            System.out.println(appliance);
        }

    }
}
