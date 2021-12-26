package ru.khrebtov.hw3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainHw3 {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        Count count = new Count(lock);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        count.increase();
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(count.getCounter());
    }
}
