package ru.croc.barkhatnat.homework7.task13;

import ru.croc.barkhatnat.homework7.AuctionActions;
import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, BidException, WinnerException, InterruptedException {
        String fileIot = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework7\\task13\\Iot.txt";
        String fileParticipants = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework7\\task13\\participants.txt";
        AuctionInformationReader auctionInformationReader = new AuctionInformationReader(fileIot, fileParticipants);
        Item item = new Item(auctionInformationReader.getItemName(), auctionInformationReader.getStartBid(), Duration.ofSeconds(1));
        ArrayList<String> participants = auctionInformationReader.getParticipants();
        AuctionActions.startAuction(item, participants);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(AuctionActions.findWinner(item));
    }
}
