package ru.croc.barkhatnat.homework7.task13;

import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Item implements ItemInterface {
    private AtomicReference<Integer> currentBid;
    private final String itemName;
    private String bidderName = null;
    private final LocalDateTime stopTime;
    private AtomicReference<String> winnerName;
    private final Lock bidLock = new ReentrantLock();



    public Item(String itemName, int startBid, Duration auctionDuration) {
        this.currentBid = new AtomicReference<>(startBid);
        this.itemName = itemName;
        this.stopTime = LocalDateTime.now().plus(auctionDuration);
        this.winnerName = new AtomicReference<>(null);
    }


    @Override
    public synchronized void placeBid(String newBidderName, int newPrice) throws BidException {
        bidLock.lock();
        try {
        if (LocalDateTime.now().isBefore(stopTime)) {
            int currentBidValue = currentBid.get();
            if (newPrice > currentBidValue) {
                    currentBid.set(newPrice);
                    bidderName = newBidderName;
                    winnerName.set(bidderName);
            }else {
                throw new BidException("The new bid must be higher than the old bid: " + getFormattedBid());
            }
        } else {
            throw new BidException("Bidding on this lot has ended at " + getFormattedDate());
        }}finally {
            bidLock.unlock();
        }
    }

    @Override
    public AtomicReference<Integer> getCurrentBid() {
        return currentBid;
    }

    @Override
    public String getWinnerName() throws WinnerException {
        String winner = winnerName.get();
        if (winner != null) {
            return winner;
        } else {
            throw new WinnerException("Auction hasn't ended yet");
        }
    }

    public String getBidderName() {
        return bidderName;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public String getFormattedBid() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return currencyFormatter.format(currentBid.get()) + "₽";
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
        return formatter.format(getStopTime());
    }

    public String getItemName() {
        return itemName;
    }
}
