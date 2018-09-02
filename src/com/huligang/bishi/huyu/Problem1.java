package com.huligang.bishi.huyu;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt() - 5000;
            if (tmp <= 0) {
                result[i] = 0;
                continue;
            }
            if (tmp > 80000) {
                result[i] += Math.round(0.45 * (tmp - 80000));
                tmp = 80000;
            }
            if (tmp > 55000) {
                result[i] += Math.round(0.35 * (tmp - 55000));
                tmp = 55000;
            }
            if (tmp > 35000) {
                result[i] += Math.round(0.3 * (tmp - 35000));
                tmp = 35000;
            }
            if (tmp > 25000) {
                result[i] += Math.round(0.25 * (tmp - 25000));
                tmp = 25000;
            }
            if (tmp > 12000) {
                result[i] += Math.round(0.2 * (tmp - 12000));
                tmp = 12000;
            }
            if (tmp > 3000) {
                result[i] += Math.round(0.1 * (tmp - 3000));
                tmp = 3000;
            }
            result[i] += Math.round(0.03 * tmp);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
