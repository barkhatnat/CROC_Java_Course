package ru.croc.barkhatnat.homework7.task13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AuctionInformationReader {
    private final String fileIot;
    private final String fileParticipants;
    private String itemName;
    private int startBid;
    ArrayList<String> participants = new ArrayList<>();
    public AuctionInformationReader(String fileIot, String fileParticipants){
        this.fileIot = fileIot;
        this.fileParticipants = fileParticipants;
        readAndSaveInformation();
    }
    private void readAndSaveInformation(){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIot))) {
            itemName = reader.readLine().trim();
            startBid = Integer.parseInt(reader.readLine().trim());
        } catch (IOException | NumberFormatException ex) {
            System.err.println("Error reading auction information file: " + ex.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileParticipants))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participants.add(line);
            }
        } catch (IOException ex) {
            System.err.println("Error reading participants file: " + ex.getMessage());
        }
    }
    public ArrayList<String> getParticipants(){
        return  new ArrayList<>(participants);
    }
    public String getItemName(){
        return itemName;
    }
    public int getStartBid(){
        return startBid;
    }
}
