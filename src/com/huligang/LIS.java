package com.huligang;

import java.util.Scanner;

/**
 * 最长递增子序列：
 *  1. 排序+LCS
 *  2. DP
 *  3. O(NlgN)
 */
public class LIS {

    /**
     * DP 方法
     * @param a
     * @return
     */
    public int lis_DP(int[] a) {
        int [] result = new int[a.length];
        getResult(a, result);
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < result[i])
                max = result[i];
        }
        return max;
    }

    private void getResult(int[] a, int[] result) {

        for (int i = 0; i < a.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && result[i] < result[j]+1) {
                    result[i] = result[j] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int[] a = {2,1,4,3,1,5,6};
        LIS lis = new LIS();
        System.out.println(lis.lis_DP(a));
    }

}
