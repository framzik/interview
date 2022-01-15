package ru.khrebtov.hw3;

import java.util.concurrent.locks.Lock;

public class Count {
    private Integer counter;
    private final Lock lock;

    public Count(Lock lock) {
        this.lock = lock;
        counter = 0;
    }

    void increase() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public Integer getCounter() {
        return counter;
    }
}
