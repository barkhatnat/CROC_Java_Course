package ru.croc.barkhatnat.homework8.task16.classes;

import java.util.Objects;

public class Pet {
    int medicalCard;
    String name;
    int age;

    public Pet(int medicalCard, String name, int age) {
        this.medicalCard = medicalCard;
        this.name = name;
        this.age = age;
    }

    public int getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(int medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Pet pet)){
            return false;
        }
        return medicalCard == pet.medicalCard;
    }
    @Override
    public int hashCode() {
        return Objects.hash(medicalCard);
    }
}
