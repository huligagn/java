package com.huligang.bishi.xunlei;

import java.util.Scanner;

public class HongHeiJiMu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i;
        for (i = 7; i >= 0; i--) {
            if ((a*i + b*(7-i)) < 0) {
                break;
            }
        }
        int[] result = new int[17];
        for (int j = 0; j < i; j++) {
            result[j] = a;
        }
        for (int j = i; j < 7; j++) {
            result[j] = b;
        }
        for (int j = 7; j < 17; j++) {
            if (result[j-7] == a)
                result[j] = a;
            else
                result[j] = b;
        }
        int count = 0;
        for (int e : result) {
            count += e;
        }
        System.out.println(count);
    }
}
