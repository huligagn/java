package com.huligang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static int collect(int[][] matrix, int r) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[r][i] != 0) {
                sum += 1;
                sum += collect(matrix, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextInt();



        int[][] input = new int[N][N];
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            input[start][end] = 1;
        }

        int [] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = collect(input,i);
        }

        int max = result[0];
        for (int i = 1; i < N; i++) {
            if(max < result[i]) max = result[i];
        }

        System.out.println(max);

    }
}
