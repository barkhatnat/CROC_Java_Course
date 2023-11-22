package ru.croc.barkhatnat.homework6.task11;

import ru.croc.barkhatnat.homework6.task11.classes.Chef;
import ru.croc.barkhatnat.homework6.task11.classes.ChefSkills;
import ru.croc.barkhatnat.homework6.task11.classes.Dish;
import ru.croc.barkhatnat.homework6.task11.classes.Ingredient;
import ru.croc.barkhatnat.homework6.task11.enums.Category;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ingredient carrot = new Ingredient("Carrot", true);
        Ingredient milk = new Ingredient("Milk", true);
        Ingredient eggs =  new Ingredient("Eggs", true);
        Ingredient chicken  =new Ingredient("Chicken", false);
        Ingredient honey  =new Ingredient("Chicken", true);
        Ingredient chocolate  =new Ingredient("Chocolate", false);
        Chef chef1 = new Chef("James", true);
        Chef chef2 = new Chef("Kyle", true);
        Chef chef3 = new Chef("Sofia", false);
        Dish dish1 = new Dish("Chocolate Milk", Category.DESSERT, new HashSet<Ingredient>(List.of(chocolate, milk)), 66, 90);
        Dish dish2 = new Dish("Chicken with honey souse", Category.MAIN, new HashSet<Ingredient>(List.of(chicken, honey)), 99, 87);
        Dish dish3 = new Dish("Carrot cake", Category.DESSERT, new HashSet<Ingredient>(List.of(carrot, milk, eggs)), 99, 100);
        HashMap<Chef, HashSet<Dish>> chefSkills = new HashMap<>();
        chefSkills.put(chef1, new HashSet<>(List.of(dish1)));
        chefSkills.put(chef2,new HashSet<>(List.of(dish2)));
        chefSkills.put(chef2, new HashSet<>(List.of(dish3)));
        ChefSkills chefSkillsClass = new ChefSkills(chefSkills);
//        Menu menu = new Menu(HashSet<Ingredient>(List.of(chicken)), chefSkillsClass);
    }
}
