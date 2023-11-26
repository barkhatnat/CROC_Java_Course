package ru.croc.barkhatnat.homework7.task13;

import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, BidException, WinnerException, InterruptedException {
        final int MAX_BID_DIFFERENCE = 1000;
        String fileIot = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework7\\task13\\Iot.txt";
        String fileParticipants = "HomeTasks\\src\\ru\\croc\\barkhatnat\\homework7\\task13\\participants.txt";
        AuctionInformationReader auctionInformationReader = new AuctionInformationReader(fileIot, fileParticipants);
        Item item = new Item(auctionInformationReader.getItemName(), auctionInformationReader.getStartBid(), Duration.ofSeconds(1));
        ArrayList<String> participants = auctionInformationReader.getParticipants();
        for (String participant : participants) {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    int bidAmount = ThreadLocalRandom.current().nextInt(item.getCurrentBid().get() + 1, item.getCurrentBid().get() + 1 + MAX_BID_DIFFERENCE);
                    try {
                        item.placeBid(participant, bidAmount);
                        System.out.println(participant + " placed a bid: " + item.getFormattedBid());
                    } catch (BidException e) {
                        System.out.println(participant + ": " + e.getMessage());
                        if (e.getMessage().contains("Bidding on this lot has ended at ")) {
                            break;
                        }
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Winner: " + item.getWinnerName());
        } catch (WinnerException e) {
            System.out.println("No winner: " + e.getMessage());
        }
    }
}
