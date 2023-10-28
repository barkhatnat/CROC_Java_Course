package ru.croc.barkhatnat.homework3.task6;

import ru.croc.barkhatnat.homework3.task6.exceptions.RadiusException;
import ru.croc.barkhatnat.homework3.task6.exceptions.RectangleException;

public class Main {
    public static void main(String[] args) throws RadiusException, RectangleException {
        Annotation area1 = new Annotation("First", new Circle(0, 0, 1));
        Annotation area2 = new Annotation("Second", new Rectangle(1, 2, 5, 6));
        AnnotatedImage annotatedImage = new AnnotatedImage("image path", area1, area2);
        System.out.println(annotatedImage.findByPoint(0, 0));
        System.out.println(annotatedImage.findByLabel("st"));
        area1.move(1, 2);
        System.out.println(area1);
        System.out.println(annotatedImage.findByPoint(5, 6));
        System.out.println(annotatedImage.findByLabel("eco"));
        area2.move(5, 6);
        System.out.println(area2);
    }
}