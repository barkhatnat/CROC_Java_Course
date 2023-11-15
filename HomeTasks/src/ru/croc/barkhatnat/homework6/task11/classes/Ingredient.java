package ru.croc.barkhatnat.homework6.task11.classes;

public class Ingredient {
    private String name;
    private boolean inStock;

    public Ingredient(String name, boolean inStock) {
        this.name = name;
        this.inStock = inStock;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
