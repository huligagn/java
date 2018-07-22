package com.huligang.concurrency;

public class Account {

    String holderName;
    float amount;
    public Account(String holderName, float amount) {
        this.holderName = holderName;
        this.amount = amount;
    }

    public synchronized void deposit(float amount) {
        this.amount += amount;
    }

    public synchronized void withdraw(float amount) {
        this.amount -= amount;
    }

    public float checkBlance() {
        return this.amount;
    }

    public static void main(String[] args) {

    }
}
