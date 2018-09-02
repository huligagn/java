package com.huligang.offer;

/**
 * 连续子数组的最大和
 */
public class Proble30 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int tmp_sum = array[0];
        for (int i = 1; i < array.length; i++) {
            tmp_sum += array[i];
            if (tmp_sum > max) {
                max = tmp_sum;
            } else if (tmp_sum < 0) {
                tmp_sum = 0;
            }
        }

        return max;
    }
}
