package ru.khrebtov;

import ru.khrebtov.hw2.MyArrayList;
import ru.khrebtov.hw2.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.insertFirst(12);
        myLinkedList.insertFirst(54);
        myLinkedList.insertLast(32);
        myLinkedList.insert(1, 88);

        System.out.println(myLinkedList.toString());

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(2);
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.add(0,12);

        System.out.println(myArrayList);
    }
}
