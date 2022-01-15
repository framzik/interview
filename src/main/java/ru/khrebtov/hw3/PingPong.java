package ru.khrebtov.hw3;

public class PingPong {
    private final Object lock = new Object();
    private volatile boolean isPingLast = false;

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();

        Thread t1 = new Thread(pingPong::writePing);

        Thread t2 = new Thread(pingPong::writePong);

        t1.start();
        t2.start();
    }

    private void writePing() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (isPingLast) {
                        lock.wait();
                    }
                    System.out.println("ping");
                    isPingLast = true;
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void writePong() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!isPingLast) {
                        lock.wait();
                    }
                    System.out.println("pong");
                    isPingLast = false;
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
