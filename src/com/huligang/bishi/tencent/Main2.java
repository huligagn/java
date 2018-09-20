package com.huligang.bishi.tencent;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            matrix[sc.nextInt()-1][sc.nextInt()-1]++;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int row = collectRow(matrix.clone(), i);
            int col = collectCol(matrix.clone(), i);
            if (row < col) count++;
        }
        System.out.println(count);

    }

    public static int collectRow(int[][] matrix, int r) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[r][i] != 0) {
                sum += matrix[r][i];
//                matrix[r][i] = 0;
                sum += collectRow(matrix, i);
            }
        }
        return sum;
    }

    public static int collectCol(int[][] matrix, int c) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][c] != 0) {
                sum += matrix[i][c];
//                matrix[i][c] = 0;
                sum += collectCol(matrix, i);
            }
        }
        return sum;
    }
}

