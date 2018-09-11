package com.huligang.bishi.netease;

import java.util.Scanner;

public class Problem2 {

    private static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        if (a[0] >= key)
            return 0;
        while((hi - lo) > 1) {
            int mid = Math.round((float)lo + (hi -lo) /2);
            if (key > a[mid]) {
                lo = mid;
            } else if (mid == 0 || key > a[mid-1]) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return hi;

//        for (int i = 0; i < a.length; i++) {
//            if (i == 0 &&a[i] >= key || a[i] >= key && a[i-1] < key) {
//                return i;
//            }
//        }
//        return a.length-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] ask = new int[M];
        for (int i = 0; i < M; i++) {
            ask[i] = sc.nextInt();
        }

        int[] a = new int[N];
        a[0] = s[0];
        for (int i = 1; i < N; i++) {
            a[i] = s[i] + a[i-1];
        }

        for (int i = 0; i < M; i++) {
            System.out.println(indexOf(a, ask[i]) + 1);
        }

    }
}
