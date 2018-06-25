package com.huligang.offer;

/**
 * 给定一个double类型的浮点数base和int类型的exponent，求base的exponent次方
 */
public class Problem12 {

    public double Power(double base, int n) {

        double res = 1, curr = base;
        int exponent;

        if (n == 0)
            return 1;
        else if (n < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为零");
            else
                exponent = -n;
        } else {
            exponent = n;
        }

        while (exponent != 0) {
            if ((exponent&1) == 1) {
                res *= curr;
            }

            curr *= curr;
            exponent >>= 1;
        }

        return n >= 0 ? res:(1/res);
    }

    public static void main(String[] args) {
        Problem12 p = new Problem12();
        System.out.println(p.Power(2,5));
    }
}
