package com.huligang.bishi.netease;

import java.util.Scanner;

public class Problem1 {

    private static int getScore(int[] score, int[] wake) {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            if (wake[i] == 1)
                sum += score[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] score = new int[N];
        int[] wake = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            wake[i] = sc.nextInt();
        }

        int result = getScore(score, wake);

        for (int i = 0; i < N; i++) {
            int tmp = result;
            for (int j = i; j < i+k && j < N; j++) {
                tmp += (1 - wake[j]) * score[j];
            }
            if (tmp > result) {
                result = tmp;
            }
        }

        System.out.println(result);
    }
}
