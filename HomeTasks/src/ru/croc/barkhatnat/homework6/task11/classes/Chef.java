package ru.croc.barkhatnat.homework6.task11.classes;

public class Chef {
    private String name;
    private boolean isOnWork;

    public Chef(String name, boolean isOnWork) {
        this.name = name;
        this.isOnWork = isOnWork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnWork() {
        return isOnWork;
    }

    public void setOnWork(boolean onWork) {
        isOnWork = onWork;
    }
}
