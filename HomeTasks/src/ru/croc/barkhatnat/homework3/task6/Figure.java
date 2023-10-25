package ru.croc.barkhatnat.homework3.task6;

public abstract class Figure implements Movable {
    public abstract boolean pointInFigure(int x, int y);
    public abstract void move(int dx, int dy);
}
