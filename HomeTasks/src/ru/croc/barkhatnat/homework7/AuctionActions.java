package ru.croc.barkhatnat.homework7;

import ru.croc.barkhatnat.homework7.task13.Item;
import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AuctionActions {
    final static int MAX_BID_DIFFERENCE = 1000;

    public static void startAuction(Item item, List<String> participants) {
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
    }

    public static String findWinner(Item item) {
        try {
            return "Winner " + item.getWinnerName() + ", bid is " + item.getFormattedBid();
        } catch (WinnerException e) {
            return "No winner";
        }
    }
}
