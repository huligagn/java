package com.huligang;

import java.util.Stack;

/**
 * 最长公共子序列问题
 */
public class LCS {
    public void lcs(int[][] matrix, String s1, String s2) {
        for (int i = 0; i <= s1.length(); i++){
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 0;
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
            }
        }
    }

    public static void main(String[] args) {

        LCS lcs = new LCS();
        String s1 = "13456778";
        String s2 = "357486782";
        int m = s1.length();
        int n = s2.length();
        int[][] result = new int[m+1][n+1];
        lcs.lcs(result, s1, s2);
        System.out.println(result[m][n]);

        Stack<Character> s = new Stack<>();
        int cur = result[m][n];
        while(m>0 && n>0) {
            if (result[m][n-1] == cur) n--;
            else if (result[m-1][n] == cur) m--;
            else {
                s.push(s1.charAt(m-1));
                m--;
                n--;
                cur = result[m][n];
            }
        }
        while(! s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}
