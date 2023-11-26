package ru.croc.barkhatnat.homework7.task13.exceptions;

public class BidException extends RuntimeException {
    public BidException(String errorMessage) {
        super(errorMessage);
    }
}