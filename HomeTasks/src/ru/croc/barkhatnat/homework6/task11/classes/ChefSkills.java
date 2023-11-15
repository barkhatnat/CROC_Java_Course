package ru.croc.barkhatnat.homework6.task11.classes;

import java.util.HashMap;
import java.util.HashSet;

public class ChefSkills {
    public HashMap<Chef, HashSet<Dish>> skills = new HashMap<>();

    public ChefSkills(HashMap<Chef, HashSet<Dish>> skills) {

        this.skills = skills;
    }

    public HashMap<Chef, HashSet<Dish>> getSkills() {
        return skills;
    }

    private void setSkills(HashMap<Chef, HashSet<Dish>> skills) {
        this.skills = skills;
    }

    public void addNewChef(Chef chef, HashSet<Dish> dishes) {
        skills.put(chef, dishes);
    }

    public void deleteChef(Chef chef) {
        skills.remove(chef);
    }

}
