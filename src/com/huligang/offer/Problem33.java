package com.huligang.offer;

import java.util.LinkedHashMap;

/**
 * 第一个只出现一次的字符
 */
public class Problem33 {

    // 感觉没有错，思路也还可以接受
    // 利用hash，有改进的空间，这个hash可以不用很复杂
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> help = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (help.containsKey(chars[i])) {
                help.put(chars[i], help.get(chars[i]) + 10000);
            } else {
                help.put(chars[i], 20000 + i);
            }
        }

        for (Character c : help.keySet()) {
            if (help.get(c) < 30000)
                return help.get(c) % 10000;
        }
        return -1;
    }

    public int anotherWay(String str) {
        char[] chars = str.toCharArray();
        int[] help = new int['z' + 1];
        for (char c : chars) {
            help[(int) c]++;
        }
        int i = 0;
        for (char c : chars) {
            if (help[(int) c] == 1)
                return i;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem33 p = new Problem33();
        String test = "google";
        System.out.println(p.anotherWay(test));
    }
}
