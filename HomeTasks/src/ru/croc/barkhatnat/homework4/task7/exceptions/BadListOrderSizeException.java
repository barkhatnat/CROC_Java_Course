package ru.croc.barkhatnat.homework4.task7.exceptions;

public class BadListOrderSizeException extends Exception{
    public BadListOrderSizeException(String errorMessage) {
        super(errorMessage);
    }
}
