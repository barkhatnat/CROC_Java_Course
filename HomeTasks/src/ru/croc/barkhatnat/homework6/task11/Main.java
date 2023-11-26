package ru.croc.barkhatnat.homework6.task11;

import ru.croc.barkhatnat.homework6.task11.classes.*;
import ru.croc.barkhatnat.homework6.task11.enums.Category;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Ingredient carrot = new Ingredient("Carrot", true);
        Ingredient milk = new Ingredient("Milk", true);
        Ingredient eggs = new Ingredient("Eggs", true);
        Ingredient chicken = new Ingredient("Chicken", false);
        Ingredient honey = new Ingredient("Chicken", true);
        Ingredient chocolate = new Ingredient("Chocolate", true);
        Ingredient cranberry = new Ingredient("Cranberry", true);
        Ingredient cranberry1 = new Ingredient("Cranberry", true);
        Ingredient cranberry2 = new Ingredient("Cranberry", true);



        Chef chef1 = new Chef("James", true);
        Chef chef2 = new Chef("Kyle", true);
        Chef chef3 = new Chef("Sofia", false);
        Chef chef4 = new Chef("Daniel", true);

        Dish dish1 = new Dish("Chocolate milk", Category.DESSERT, new HashSet<Ingredient>(List.of(chocolate, milk)), 66, 90);
        Dish dish2 = new Dish("Chicken with honey souse", Category.MAIN, new HashSet<Ingredient>(List.of(chicken, honey)), 99, 87);
        Dish dish3 = new Dish("Carrot cake", Category.DESSERT, new HashSet<Ingredient>(List.of(carrot, milk, eggs)), 99, 100);
        Dish dish4 = new Dish("Omelette", Category.APPETIZER, new HashSet<Ingredient>(List.of(milk, eggs)), 54, 67);
        Dish dish5 = new Dish("Cranberry brownie", Category.DESSERT, new HashSet<Ingredient>(List.of(chocolate, cranberry, cranberry2, cranberry1, milk, eggs)), 66, 30);
        Dish dish6 = new Dish("Cranberry brownie with honey cream", Category.DESSERT, new HashSet<Ingredient>(List.of(chocolate, cranberry, honey, milk, eggs)), 75, 45);
        Dish dish7 = new Dish("Chicken with cranberry", Category.DESSERT, new HashSet<Ingredient>(List.of(cranberry,chicken)), 2, 7);

        HashMap<Chef, HashSet<Dish>> chefSkillsMap = new HashMap<>();
        chefSkillsMap.put(chef1, new HashSet<>(List.of(dish1, dish7)));
        chefSkillsMap.put(chef2, new HashSet<>(List.of(dish2, dish6)));
        chefSkillsMap.put(chef3, new HashSet<>(List.of(dish3, dish5)));
        chefSkillsMap.put(chef4, new HashSet<>(List.of(dish4, dish5)));
        ChefSkills chefSkills = new ChefSkills(chefSkillsMap);
        Predicate<Dish> containsCranberry = dish -> dish.ingredients().contains(cranberry1);
        MenuCreator menuCreator1 = new MenuCreator(chefSkills.getSkills(), 5);
        List<Dish> menuWithoutSpecialWish= menuCreator1.generateMenu();
        System.out.println("Menu without special wish:");
        for (Dish menuItem : menuWithoutSpecialWish) {
            System.out.println(menuItem.name() + " - King's grade: "+ menuItem.kingsGrade() + " Courtiers' grade: " + menuItem.courtiersGrade());
        }
        System.out.println('\n');
        MenuCreator menuCreator2 = new MenuCreator(chefSkills.getSkills(), 5, containsCranberry);
        List<Dish> menuOnlyWithCranberry= menuCreator2.generateMenu();
        System.out.println("Menu with only cranberry dishes:");
        for (Dish menuItem : menuOnlyWithCranberry) {
            System.out.println(menuItem.name() + " - King's grade: "+ menuItem.kingsGrade() + " Courtiers' grade: " + menuItem.courtiersGrade());
        }


    }
}
