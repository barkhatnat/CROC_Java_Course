package ru.croc.barkhatnat.homework3.task6;

import ru.croc.barkhatnat.homework3.task6.exceptions.RadiusException;

public class Circle extends Figure implements Movable {
    public int x0, y0, r;

    public Circle(int x0, int y0, int r) throws RadiusException {
        this.x0 = x0;
        this.y0 = y0;
        if (r > 0) {
            this.r = r;
        } else {
            throw new RadiusException("Radius can't be negative");
        }
    }

    @Override
    public String toString() {
        return String.format("Circle (%d, %d), %d: ", x0, y0, r);
    }

    @Override
    public boolean pointInFigure(int x, int y) {
        return Math.pow(x - x0, 2) + Math.pow(y - y0, 2) <= Math.pow(r, 2);
    }

    @Override
    public void move(int dx, int dy) {
        x0 += dx;
        y0 += dy;
    }

    public int getX0() {
        return x0;
    }

    private void setX0(int x0) {
        this.x0 = x0;
    }

    public int getY0() {
        return y0;
    }

    private void setY0(int y0) {
        this.y0 = y0;
    }

    public int getR() {
        return r;
    }

    private void setR(int r) throws RadiusException {
        if (r > 0) {
            this.r = r;
        } else {
            throw new RadiusException("Radius can't be negative");
        }
    }
}
