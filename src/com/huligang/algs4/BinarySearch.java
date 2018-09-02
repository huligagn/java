package com.huligang.algs4;

import java.util.Arrays;

public class BinarySearch {

    private static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi -lo) /2;
            if (key > a[mid]) {
                lo = mid;
            } else if (key < a[mid]) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static String getString(int[] a) {
        StringBuilder a_str = new StringBuilder("[ ");
        for (int anA : a) {
            a_str.append(anA).append(" ");
        }
        a_str.append("]");
        return a_str.toString();
    }

    public static void main(String[] args) {
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
