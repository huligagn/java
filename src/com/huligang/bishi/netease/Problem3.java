package com.huligang.bishi.netease;

import java.util.Scanner;
import java.util.TreeMap;

public class Problem3 {

    private static TreeMap<String, Integer> result = new TreeMap<>();

    private static void swap(char[] str, int i, int j)
    {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    private static void arrange(char[] str, int st, int len)
    {
        if (st == len - 1)
        {
            result.put(String.valueOf(str), 1);
        }
        else
        {
            for (int i = st; i < len; i ++)
            {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        char[] str = new char[N + M];
        for (int i = 0; i < N; i++) {
            str[i] = 'a';
        }
        for (int i = N; i < (N + M); i++) {
            str[i] = 'z';
        }
        arrange(str, 0, str.length);
        if (result.size() < K) {
            System.out.println(-1);
        } else {
            int id = 1;
            for (String k : result.keySet()) {
                if (id == K) {
                    System.out.println(k);
                }
                id++;
            }
        }

    }
}
