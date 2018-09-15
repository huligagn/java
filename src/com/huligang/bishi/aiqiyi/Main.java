package com.huligang.bishi.aiqiyi;
import java.util.Scanner;

public class Main {

    private static int sumOfTopTwo(int[] a) {
        int max=Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                a[i] = Integer.MIN_VALUE;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (max2 < a[i]) {
                max2 = a[i];
                a[i] = Integer.MIN_VALUE;
            }
        }
        return max+max2;
    }

    private static int max(int[] a) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split("");
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }

        int head = nums[0] + nums[1] + nums[2];
        int tail = nums[3] + nums[4] + nums[5];

        if (head == tail) {
            System.out.println(0);
        } else if (head < tail) {
            int gap = tail - head;
            int g1 = 9 - nums[0];
            int g2 = 9 - nums[1];
            int g3 = 9 - nums[2];
            int[] tmp = {g1,g2,g3,nums[3], nums[4], nums[5]};
            if (max(tmp) >= gap)
                System.out.println(1);
            else if (sumOfTopTwo(tmp) >= gap)
                System.out.println(2);
            else
                System.out.println(3);
        } else {
            int gap = head - tail;
            int g1 = 9 - nums[3];
            int g2 = 9 - nums[4];
            int g3 = 9 - nums[5];
            int[] tmp = {g1,g2,g3,nums[0], nums[1], nums[2]};
            if (max(tmp) >= gap)
                System.out.println(1);
            else if (sumOfTopTwo(tmp) >= gap)
                System.out.println(2);
            else
                System.out.println(3);
        }
    }
}

