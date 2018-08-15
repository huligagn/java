package com.huligang.offer;
import java.util.*;

/**
 * 字符串全排列问题，这里使用了TreeMap来实现去重和排序功能，当然也可以用if list.contains() 去重和Collections.sort()来排序
 */
public class Problem27 {

    public ArrayList<String> Permutation(String s) {
        char[] chars = s.toCharArray();
        TreeMap<String, Integer> result = new TreeMap<>();
        permutation(chars, 0, result);
        return new ArrayList<>(result.keySet());
    }

    private void permutation(char[] chars, int index, TreeMap<String, Integer> result) {
        if (index == chars.length-1) {
            result.put(String.valueOf(chars), 1);
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutation(chars, index+1, result);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Problem27 p = new Problem27();
        List<String> result = p.Permutation(input);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
