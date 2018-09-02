package com.huligang.offer;

/**
 * 青蛙可以跳上1级2级...n级台阶，求跳上n级台阶的跳法有多少种
 */
public class Problem9 {
    public int jumpFloor(int n) {
        if (n <= 0) return -1;
        else return 1<<(n-1);
    }

    public static void main(String[] args) {
        Problem9 p = new Problem9();
        System.out.println(p.jumpFloor(1));
        System.out.println(p.jumpFloor(2));
        System.out.println(p.jumpFloor(3));
        System.out.println(p.jumpFloor(4));
        System.out.println(p.jumpFloor(5));
    }
}
