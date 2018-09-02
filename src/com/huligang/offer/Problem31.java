package com.huligang.offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class Problem31 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i< len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) -> {
            String c1 = o1+o2;
            String c2 = o2+o1;
            return c1.compareTo(c2);
        });

        for (String s : str) {
            result.append(s);
        }
        return result.toString();
    }
}
