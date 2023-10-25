package ru.croc.barkhatnat.homework3.task6;

import ru.croc.barkhatnat.homework3.task6.exceptions.RectangleException;

public class Rectangle extends Figure implements Movable {
    private int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) throws RectangleException {
        this.x1 = x1;
        this.y1 = y1;
        if (x2 > x1 && y2 > y1) {
            this.x2 = x2;
            this.y2 = y2;
        } else {
            throw new RectangleException("Rectangles are defined by the coordinates of the lower left and upper right corners.");
        }
    }

    @Override
    public String toString() {
        return String.format("Rectangle (%d, %d), (%d, %d): ", x1, y1, x2, y2);
    }

    @Override
    public boolean pointInFigure(int x, int y) {
        return (x1 <= x) && (x <= x2) && (y1 <= y) && (y <= y2);
    }

    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public int getX1() {
        return x1;
    }

    private void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    private void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    private void setX2(int x2) throws RectangleException {
        if (this.x2 > x1) {
            this.x2 = x2;
        }else {
            throw new RectangleException("Rectangles are defined by the coordinates of the lower left and upper right corners.");
        }
    }

    public int getY2() {
        return y2;
    }

    private void setY2(int y2) throws RectangleException {
        if (this.y2 > y1) {
            this.y2 = y2;
        }else {
            throw new RectangleException("Rectangles are defined by the coordinates of the lower left and upper right corners.");
        }
    }
}
