package ru.khrebtov.hw1.polymorf;

public class Rectangle implements Shape{
    int length;
    int height;

    public Rectangle(int length, int height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public double area() {
        return length*height;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь прямоугольника: "+ area());
    }
}
