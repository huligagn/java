package com.huligang.bishi.netease;

import java.util.Scanner;

public class Problem4 {

    private static int getScore(int[] score, int[] wake) {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i] * wake[i];
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

        int result = 0;

        for (int i = 0; i < N; i++) {
            int[] copy = new int[N];
            System.arraycopy(wake,0, copy, 0, N - 1);
            for (int j = i; j < i+k && j < N; j++) {
                copy[j] = 1;
            }
            int tmp = getScore(score, copy);
            if (tmp > result) {
                result = tmp;
            }
        }

        System.out.println(result);
    }
}
