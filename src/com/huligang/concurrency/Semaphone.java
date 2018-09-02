package com.huligang.concurrency;

public class Semaphone {

    private int count;

    public Semaphone(int n) {
        this.count = n;
    }

    public synchronized void acquire() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
    }

    public synchronized void release() {
        count++;
        notify();
    }
}
