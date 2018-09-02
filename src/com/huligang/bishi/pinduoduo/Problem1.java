package com.huligang.bishi.pinduoduo;

import java.util.Scanner;

/**
 * 数组的山谷，山谷定义为先减少再增加的子数组（如543267）
 * 求给定数组的最大山谷长度
 *
 * 总结：没有考虑好边界条件！！！
 */
public class Problem1 {

    public static int get(int[] a, int id){
        int count = 0;
        int i;
        for (i = id; i < a.length-1; i++) {
            count++;
            if (a[i+1] > a[i])
                break;
        }
        if (count == 1)
            return count;
        for (int j = i+1; j< a.length-1; j++) {
            count++;
            if (a[j+1] < a[j])
                break;
        }
        return count+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [4,3,2,5,3,1,4,8]
        String str = sc.nextLine();
        str = str.substring(1,str.length()-1);
        String[] tmp = str.split(",");
        int[] a = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            a[i] = Integer.parseInt(tmp[i]);
        }
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            if (max < get(a, i))
                max = get(a, i);
        }

        if (max < 3)
            System.out.println(0);
        else
            System.out.println(max);

    }
}
