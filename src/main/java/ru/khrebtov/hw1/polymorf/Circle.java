package ru.khrebtov.hw1.polymorf;

public class Circle implements Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь круга: " + area());
    }
}
