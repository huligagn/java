package com.huligang.bishi.jingdong;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void collect(int[][] matrix, int r, HashSet<Integer> result) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[r][i] == 0) {
                matrix[r][i] = 1;
                result.add(i);
                collect(matrix, i, result);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][N];
            HashSet<Integer> all = new HashSet<>();
            HashSet<Integer> res = new HashSet<>();
            for (int j = 0; j < M*2; j+=2) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                matrix[x-1][y-1] = 1;
                matrix[y-1][x-1] = 1;
            }
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                res.clear();
                collect(matrix, j, res);
                if (res.size() == N) {
                    System.out.println("No");
                    flag = false;
                    break;
                } else {
                    all.addAll(res);
                }
            }
            if (all.size() == N && flag) {
                System.out.println("Yes");
            }
        }
    }
}
