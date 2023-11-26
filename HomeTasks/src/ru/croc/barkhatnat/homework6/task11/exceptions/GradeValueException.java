package ru.croc.barkhatnat.homework6.task11.exceptions;

public class GradeValueException extends RuntimeException{
    public GradeValueException(String errorMessage) {
        super(errorMessage);
    }
}

