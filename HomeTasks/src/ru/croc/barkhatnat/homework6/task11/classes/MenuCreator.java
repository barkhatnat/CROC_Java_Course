package ru.croc.barkhatnat.homework6.task11.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MenuCreator {
    private ArrayList<Dish> menu;

    public MenuCreator(HashSet<Ingredient> notAvailableIngredients, HashMap<Chef, HashSet<Dish>> chefSkills, int dishNumber) {
        createMenu(notAvailableIngredients, chefSkills, dishNumber);
    }

    private void createMenu(HashSet<Ingredient> notAvailableIngredients, HashMap<Chef, HashSet<Dish>> chefSkills, int dishNumber) {
        for (Chef chef : chefSkills.keySet()) {
            if (chef.isOnWork()) {
                for (Dish dish : chefSkills.get(chef)) {
                    for (Ingredient ingredient : dish.ingredients()) {
                        if (!notAvailableIngredients.contains(ingredient)) {
                            if (menu.size() < dishNumber) {
                                menu.add(dish);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        menu.sort(new DishComparator());
    }

    public ArrayList<Dish> getMenu() {
        return menu;
    }
}
