package com.huligang.bishi.ali;

import java.util.Scanner;

public class Main {

    public static boolean check(int[] array, int step) {
        for (int j = 0; j < step; j++) {
            int tmp = array[step+j+step] - array[step+j];
            for (int i = step+j+step; i < array.length; i+=step) {
                if (array[i] - array[i-step] != tmp)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 1; i <= n/3; i++) {
            if (check(input, i) && i==1)
                count = n-6+2;
            else if (check(input, i)) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
