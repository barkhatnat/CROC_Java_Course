package ru.croc.barkhatnat.homework8.task16.classes;

import java.util.Objects;

public class Client {
    private int id;
    private String surname;
    private String name;
    private String phoneNumber;

    public Client(int id, String surname, String name, String phone_number) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Client client)){
            return false;
        }
        return id == client.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

