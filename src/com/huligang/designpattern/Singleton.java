package com.huligang.designpattern;

/**
 * 饿汉-单例模式
 */
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.instance;
    }
}
