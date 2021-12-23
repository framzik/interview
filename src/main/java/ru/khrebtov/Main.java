package ru.khrebtov;

import ru.khrebtov.hw1.Person;
import ru.khrebtov.hw1.polymorf.Circle;
import ru.khrebtov.hw1.polymorf.Rectangle;
import ru.khrebtov.hw1.polymorf.Shape;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("Jon", "Makkonahi")
                .age(52)
                .address("Boston")
                .phone("911")
                .build();

        System.out.println(person.toString());

        Shape[] shapes = new Shape[4];

        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(1, 1);
        shapes[2] = new Circle(2);
        shapes[3] = new Rectangle(2, 2);

        for (Shape shape : shapes) {
            shape.printArea();
        }

    }
}
