package com.huligang.offer;

/**
 * 用n个2*1的小矩形无重叠地覆盖2*n的大矩形
 */
public class Problem10 {

    public int cover(int n) {
        if (n <= 0) return -1;
        else if (n == 1) return 1;
        else if (n == 2) return 2;

        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        Problem10 p = new Problem10();
        System.out.println(p.cover(1));
        System.out.println(p.cover(2));
        System.out.println(p.cover(3));
        System.out.println(p.cover(4));
        System.out.println(p.cover(5));
    }
}
