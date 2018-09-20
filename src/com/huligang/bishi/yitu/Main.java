package com.huligang.bishi.yitu;

import java.util.Scanner;

/**
 * 0表示水，1表示陆地，求给定矩阵的最大连接陆地，注意斜着相连不算
 * 输入是个字符串，要求复杂度o(NM)，N表示行，M表示列
 * 下面的算法有问题！
 */
public class Main {

    public static int collect(int[][] array, int n, int m, int i, int j) {
        int count = 0;
        if (array[i][j] == 0) return count;
        else {
            count++;
            array[i][j] = 0;
            if (i > 0) count += collect(array, n, m, i-1, j);
            if (i < n-1) count += collect(array, n, m, i+1, j);
            if (j > 0) count += collect(array, n, m, i, j-1);
            if (j < m-1) count += collect(array, n, m, i, j+1);
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();
        String[] rows = raw.split(",");
        int N = rows.length;
        String[] col = rows[0].split(",");
        int M = col.length;

        int[][] input = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = rows[i].split(",");
            for (int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(tmp[j].replaceAll("[\\[\\]]", ""));
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = collect(input, N, M, i , j);
                if (tmp > max) max = tmp;
            }
        }
        System.out.println(max);
    }
}
