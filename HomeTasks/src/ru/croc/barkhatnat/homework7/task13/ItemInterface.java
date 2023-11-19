package ru.croc.barkhatnat.homework7.task13;

import ru.croc.barkhatnat.homework7.task13.exceptions.BidException;
import ru.croc.barkhatnat.homework7.task13.exceptions.WinnerException;

import java.util.concurrent.atomic.AtomicReference;

public interface ItemInterface {
    public void placeBid(String bidderName, int newPrice) throws BidException;

    public AtomicReference<Integer> getCurrentBid();

    public String getWinnerName() throws WinnerException;
}
