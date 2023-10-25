package ru.croc.barkhatnat.homework3.task6;

public class Annotation {
    public String signature;
    public Figure figure;

    public Annotation(String signature, Figure figure) {
        this.signature = signature;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return figure.toString() + signature;
    }
    public void move(int dx, int dy){
        figure.move(dx,dy);
    }
}
