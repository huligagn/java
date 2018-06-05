package com.huligang.algs4;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    private static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    private static String getString(int[] a) {
        String a_str = "[ ";
        for (int i = 0; i < a.length; i++) {
            a_str += a[i] + " ";
        }
        a_str += "]";
        return a_str;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[] a = new int[num];
//        for (int i = 0; i < num; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        int key = sc.nextInt();
        int[] a = {1, 3, 5, 2, 4};
        int key = 4;

        Arrays.sort(a);
        int id = BinarySearch.indexOf(a, key);

        if (id != -1) {
            System.out.println("the sorted array: " + BinarySearch.getString(a));
            System.out.println("Find the id of the key "+key+" : " + id);
        } else {
            System.out.print("Not found.");
        }
    }
}
