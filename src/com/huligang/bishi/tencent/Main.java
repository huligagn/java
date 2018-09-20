package com.huligang.bishi.tencent;

import java.util.Scanner;

public class Main {

    public static int getMin(int N) {
        for(int i=N;i>=1;i--){
            boolean f=true;
            for(int j=(int)Math.floor(Math.sqrt(i));j>1;j--){
                if(i%j==0 && i/j!=j && i/j%j!=0){
                    f=false;
                    break;
                }
            }
            if(f) return i<<1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getMin(n));
    }
}
