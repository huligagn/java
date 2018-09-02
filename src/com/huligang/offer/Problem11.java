package com.huligang.offer;

/**
 * 整数的二进制表示中1个个数
 */
public class Problem11 {

    public int numberOfOnes(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        Problem11 p = new Problem11();
        System.out.println(p.numberOfOnes(10));
    }
}
