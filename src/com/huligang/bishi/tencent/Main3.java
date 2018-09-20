package com.huligang.bishi.tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        int[][] nums=new int[t][3];
        for (int i = 0; i < t ; i++) {
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            nums[i][2]=sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            if (check(nums[i][0],nums[i][1],nums[i][2]))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    public static boolean check(int a, int b, int c){
        if (a%b == 0 && c!=0) return false;
        if (a%b == c) return true;
        for (int i = 2; i <= b ; i++) {
            int num = i*a;
            if (num % b == c)
                return true;
        }
        return false;
    }
}