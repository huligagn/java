package com.huligang.concurrency;

import java.util.Date;

public class TimePrinterRunnable implements Runnable {

    int pauseTime;
    String name;

    public TimePrinterRunnable(int pauseTime, String name) {
        this.pauseTime = pauseTime;
        this.name = name;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println(name + ": " + new Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread( new TimePrinterRunnable(1000, "Fast Guy"));
        t1.start();
        Thread t2 = new Thread( new TimePrinterRunnable(3000, "Slow Guy"));
        t2.start();
    }
}
