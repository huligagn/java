package com.huligang.offer;

/**
 * 输出第n个斐波那契数列
 */
public class Problem7 {

    public int getNthFibo(int n) {
        int first=1, second=1;
        int tmp;
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        for (int i = 3; i <= n; i++) {
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args) {

        Problem7 p = new Problem7();
        System.out.println(p.getNthFibo(5));
    }
}
