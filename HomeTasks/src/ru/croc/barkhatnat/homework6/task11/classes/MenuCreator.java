package ru.croc.barkhatnat.homework6.task11.classes;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MenuCreator {
    //для составления меню я не использую сет из отсутствующих на кухне ингредиентов
    // потому что я реализовала класс Ingredient, где имеется поле inStock
    private final HashMap<Chef, HashSet<Dish>> chefSkills;
    private final int dishNumber;
    private final Predicate<Dish> specialWish;
    private final DishComparator dishComparator = new DishComparator();
    public MenuCreator(Map<Chef, HashSet<Dish>> chefSkills, int dishNumber) {
        this.chefSkills = new HashMap<>(chefSkills);
        this.dishNumber = dishNumber;
        this.specialWish = dish -> true;
    }
    public MenuCreator(Map<Chef, HashSet<Dish>> chefSkills, int dishNumber, Predicate<Dish> specialWish) {
        this.chefSkills = new HashMap<>(chefSkills);
        this.dishNumber = dishNumber;
        this.specialWish = specialWish;
    }

    public List<Dish> generateMenu() {
        List<Dish> allDishes = getAllAvailableDishes();
        allDishes = allDishes.stream()
                .filter(specialWish)
                .sorted((d1, d2) -> dishComparator.compare(d2, d1))
                .limit(dishNumber)
                .collect(Collectors.toList());
        return allDishes;
    }

    private List<Dish> getAllAvailableDishes() {
        List<Dish> availableDishes = new ArrayList<>();
        for (Chef chef : chefSkills.keySet()) {
            if (chef.isOnWork()) {
                for (Dish dish : chefSkills.get(chef)) {
                    boolean allIngredientsAvailable = true;
                    for (Ingredient ingredient : dish.ingredients()) {
                        if (!ingredient.isInStock()) {
                            allIngredientsAvailable = false;
                            break;
                        }
                    }
                    if (allIngredientsAvailable) {
                        availableDishes.add(dish);
                    }
                }

            }
        }
        return availableDishes;
    }


    public int getDishNumber() {
        return dishNumber;
    }

    public HashMap<Chef, HashSet<Dish>> getChefSkills() {
        return new HashMap<>(chefSkills);
    }
}
