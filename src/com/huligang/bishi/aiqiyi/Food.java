package com.huligang.bishi.aiqiyi;

import java.util.Scanner;

public class Food {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();

        int[] food = new int[N];
        for (int i = 0; i < N; i++) {
            food[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            String flag = sc.next();
            int target = sc.nextInt() - 1;
            if (flag.equals("A")) {
                food[target]++;
            } else {
                food[target]--;
            }
        }

        int count = 1;
        for (int i = 0; i < N; i++) {
            if (food[i] > food[P-1])
                count++;
        }
        System.out.println(count);
    }
}
