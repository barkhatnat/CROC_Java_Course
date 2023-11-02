package ru.croc.barkhatnat.homework4.task7.classes;

import ru.croc.barkhatnat.homework4.task7.exceptions.BadPhoneNumberException;
import ru.croc.barkhatnat.homework4.task7.interfaces.ClientInterface;

public class Client implements ClientInterface {
    private String fullName;
    private String phoneNumber;
    private boolean isMale;

    public Client(String fullName, String phoneNumber, boolean isMale) throws BadPhoneNumberException {
        if (!phoneNumber.matches("\\d{11}")) {
            throw new BadPhoneNumberException("Phone number must contain 11 numbers");
        }
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.isMale = isMale;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
}