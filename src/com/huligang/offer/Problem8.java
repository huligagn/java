package com.huligang.offer;

/**
 * 青蛙一次可以跳1级或者2级，跳上n级台阶共有多少种跳法
 */
public class Problem8 {

    public int jumpFloor(int n) {
        if (n <= 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return jumpFloor(n-1)+jumpFloor(n-2);
    }

    public int jumpFloor2(int n) {
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
        Problem8 p = new Problem8();
//        System.out.println(p.jumpFloor2(3));
        System.out.println(p.jumpFloor(3) == p.jumpFloor2(3));
        System.out.println(p.jumpFloor(4) == p.jumpFloor2(4));
        System.out.println(p.jumpFloor(5) == p.jumpFloor2(5));
        System.out.println(p.jumpFloor(6) == p.jumpFloor2(6));
    }
}
