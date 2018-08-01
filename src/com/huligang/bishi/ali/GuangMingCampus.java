package com.huligang.bishi.ali;

public class GuangMingCampus {

    public static int find(int i, int j, int step, int[][] map) {
        int N = map.length;
        if (step == 1) {
            return map[i][j];
        } else {
            int shortest = Integer.MAX_VALUE;
            for (int x = 0; x < N; x++) {
                if (x == i || x == j)
                    continue;
                shortest = Math.min(shortest, find(i, x, step/2, map)+find(x, j, step-step/2, map));
            }
            return shortest;
        }
    }

    public static void main(String[] args) {
        int N = 3, M = 2;
        int[][] map = {
                {0, 2, 3},
                {2, 0, 1},
                {3, 1, 0}
        };
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = find(i, j, M, map);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j]);
                if (j != N-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }
}
