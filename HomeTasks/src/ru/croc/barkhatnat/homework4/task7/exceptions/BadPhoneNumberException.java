package ru.croc.barkhatnat.homework4.task7.exceptions;

public class BadPhoneNumberException extends Exception{
    public BadPhoneNumberException(String errorMessage) {
        super(errorMessage);
    }
}
