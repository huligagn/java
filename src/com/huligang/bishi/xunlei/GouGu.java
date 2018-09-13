package com.huligang.bishi.xunlei;

import java.util.Scanner;

public class GouGu {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = (int)Math.sqrt(0.5d + n);
        int count=0;
        for (int i = 1; i <= m; i++){
            for (int j = i + 1; j <= m; j += 2){
                if (gcd(j, i) == 1) {
                    if (i * i + j * j <= n) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
