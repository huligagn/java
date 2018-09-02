package com.huligang.offer;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 */
public class Problem28 {

    // 快排，然后统计（自己想的）
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int flag = array[0];
        int count = 1;
        int i;
        for (i = 1; i < array.length; i++) {
            if (array[i] == flag) {
                count++;
            } else {
                flag = array[i];
                count = 1;
            }
            if (count > array.length/2) {
                return flag;
            }
        }
        return 0;
    }

    // 快排，如果存在该值，则一定是array[array.length/2]
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array.length < 1) {
            return 0;
        }
        Arrays.sort(array);
        int flag = array[array.length/2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == flag) {
                count++;
            }
        }
        if (count > array.length/2) {
            return flag;
        } else {
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution3(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int flag = array[0];
        int count = 1;
        for (int anArray : array) {
            if (anArray == flag) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                count = 1;
                flag = anArray;
            }
        }

        count = 0;
        for (int anArray : array) {
            if (anArray == flag) {
                count++;
            }
        }
        if (count > array.length/2) {
            return flag;
        } else {
            return 0;
        }
    }
}
