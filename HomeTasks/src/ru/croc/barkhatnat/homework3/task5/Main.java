package ru.croc.barkhatnat.homework3.task5;

import ru.croc.barkhatnat.homework3.task5.classes.*;
import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InductionStove inductionStove = new InductionStove(15472, "Description for InductionStove", new ArrayList<>(Arrays.asList(1f, 1.3f, 2f)), 41.8f, 280);
        GasStove gasStove = new GasStove(4562, "Description for GasStove", new ArrayList<>(Arrays.asList(1.2f, 1.7f, 2.5f)), 16.8f, 350);
        ElectricStove electricStove = new ElectricStove(8952, "Description for ElectricStove", new ArrayList<>(Arrays.asList(1.1f, 1.7f, 1.1f)), 7.8f, 240);
        DryerWashingMachine dryerWashingMachine = new DryerWashingMachine(3112, "Description for DryerWashingMachine", new ArrayList<>(Arrays.asList(2f, 1.3f, 2.3f)), 78.8f);
        NoDryerWashingMachine noDryerWashingMachine = new NoDryerWashingMachine(3112, "Description for NoDryerWashingMachine", new ArrayList<>(Arrays.asList(2f, 2.3f, 2f)), 56.8f);
        MiniFridge miniFridge = new MiniFridge(7888, "Description for MiniFridge", new ArrayList<>(Arrays.asList(1f, 0.8f, 0.8f)), 100.8f);
        FreezerFridge freezerFridge = new FreezerFridge(15426, "Description for FreezerFridge", new ArrayList<>(Arrays.asList(1.2f, 2.8f, 1.5f)), 200.8f, -20);
        NoFreezerFridge noFreezerFridge = new NoFreezerFridge(10426, "Description for NoFreezerFridge", new ArrayList<>(Arrays.asList(1.2f, 2.5f, 1.5f)), 180f);
        RobotVacuumCleaner robotVacuumCleaner = new RobotVacuumCleaner(35421, "I wanna be your vacuum cleaner\n" +
                "Breathing in your dust\nI wanna be your Ford Cortina\nI won't ever rust\nIf you like your coffee hot\n" +
                "Let me be your coffee pot\nYou call the shots babe\nI just wanna be yours", new ArrayList<>(Arrays.asList(0.3f, 0.3f, 0.15f)), 42, 15);
        ArrayList<IHouseholdAppliance> householdApplianceArrayList = new ArrayList<IHouseholdAppliance>(Arrays.asList(inductionStove, gasStove, electricStove,
                dryerWashingMachine, noDryerWashingMachine, miniFridge, freezerFridge, noFreezerFridge, robotVacuumCleaner));
        for (IHouseholdAppliance appliance : householdApplianceArrayList) {
            System.out.println(appliance);
        }
    }
}
