package com.huligang.bishi.wangyi;

import java.util.Scanner;

public class Problem3 {

    private static int count(char[][] matrix, int m, int n, String target) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += count(matrix, m, n, i, j, target);
            }
        }
        return sum;
    }

    private static int count(char[][] matrix, int m, int n, int x, int y, String target) {
        int sum = 0;
        if (x + target.length() <= m && y + target.length() <= n) {
            StringBuilder sb = new StringBuilder();
            for (int i = x, j = y; i < x+target.length() && j < y+target.length();) {
                sb.append(matrix[i][j]);
                // TODO: 记住这种情况，两个++不能写在for里面？？？
                i++;
                j++;
            }
            if (target.equals(sb.toString())) {
                sum += 1;
            }
        }
        if (x + target.length() <= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = x; i < x + target.length(); i++) {
                sb.append(matrix[i][y]);
            }
            if (target.equals(sb.toString())) {
                sum += 1;
            }
        }

        if (y + target.length() <= n) {
            StringBuilder sb = new StringBuilder();
            for (int j = y; j < y + target.length(); j++) {
                sb.append(matrix[x][j]);
            }
            if (target.equals(sb.toString())) {
                sum += 1;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            char[][] tmp = new char[m][n];
            for (int j = 0; j < m; j++) {
                String s = sc.nextLine();
                char[] chars = s.toCharArray();
                if (n >= 0) System.arraycopy(chars, 0, tmp[j], 0, n);
            }
            String target = sc.nextLine();
            result[i] = count(tmp, m, n, target);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }

    }
}
