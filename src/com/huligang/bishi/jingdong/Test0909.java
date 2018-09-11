package com.huligang.bishi.jingdong;

import java.util.HashSet;
import java.util.Scanner;

public class Test0909 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Integer res = 0;
            HashSet<Integer> tmp = new HashSet<>();
            for (int j = 0; j < M * 2; j++) {
                int a = sc.nextInt();
                tmp.add(a);
                res = res ^ a;
            }
            if (res.equals(0) && tmp.size() == N) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
