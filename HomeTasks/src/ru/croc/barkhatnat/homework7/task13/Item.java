package ru.croc.barkhatnat.homework7.task13;

import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;


public class Item implements ItemInterface {
    private AtomicReference<Integer> currentBid;
    private final String itemName;
    private String bidderName = null;
    private final LocalDateTime stopTime;
    private AtomicReference<String> winnerName;

    public Item(String itemName, int startBid) {
        this.currentBid = new AtomicReference<>(startBid);
        this.itemName = itemName;
        this.stopTime = LocalDateTime.now().plusNanos(99999999);
        this.winnerName = new AtomicReference<>(null);
    }


    @Override
    public synchronized void placeBid(String newBidderName, int newPrice) throws BidException {
        if (LocalDateTime.now().isBefore(stopTime)) {
            if (newPrice > currentBid.get()) {
                currentBid.set(newPrice);
                bidderName = newBidderName;
                winnerName.set(bidderName);
            } else {
                throw new BidException("The new bid must be higher than the old bid: " + getFormattedBid());
            }
        } else {
            throw new BidException("Bidding on this lot has ended at " + getFormattedDate());
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

    private String getFormattedBid() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return currencyFormatter.format(currentBid.get()) + "₽";
    }

    private String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
        return formatter.format(getStopTime());
    }

    public String getItemName() {
        return itemName;
    }
}
