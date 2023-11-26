package ru.croc.barkhatnat.homework6.task11.classes;

import java.util.Objects;

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
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Ingredient ingredient)){
            return false;
        }

        return name.equals(ingredient.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
