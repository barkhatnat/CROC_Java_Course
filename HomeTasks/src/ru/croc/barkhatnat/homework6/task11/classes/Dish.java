package ru.croc.barkhatnat.homework6.task11.classes;

import ru.croc.barkhatnat.homework6.task11.enums.Category;
import ru.croc.barkhatnat.homework6.task11.exceptions.GradeValueException;

import java.util.HashSet;

public record Dish(String name, Category category, HashSet<Ingredient> ingredients, int kingsGrade, int courtiersGrade) {
    public Dish {
        if (kingsGrade < 0 || kingsGrade > 100) {
            try {
                throw new GradeValueException("King's grade must be between 0 and 100");
            } catch (GradeValueException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        if (courtiersGrade < 0 || courtiersGrade > 100) {
            try {
                throw new GradeValueException("Courtiers' grade must be between 0 and 100");
            } catch (GradeValueException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
