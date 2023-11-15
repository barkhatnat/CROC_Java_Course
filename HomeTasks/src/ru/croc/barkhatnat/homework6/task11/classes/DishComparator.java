package ru.croc.barkhatnat.homework6.task11.classes;

import java.util.Comparator;

public class DishComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish dish1, Dish dish2) {
        if (dish1.kingsGrade() != dish2.kingsGrade()) {
            return Integer.compare(dish1.kingsGrade(), dish2.kingsGrade());
        } else {
            return Integer.compare(dish1.courtiersGrade(), dish2.courtiersGrade());
        }
    }
}