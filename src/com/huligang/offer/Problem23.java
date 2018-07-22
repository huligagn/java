package com.huligang.offer;

/**
 * 判断是否为二叉搜索树的后序遍历序列
 */
public class Problem23 {

    private boolean check(int[] a, int i, int j) {
        if (i >= j)
            return true;
        int tmp = a[j];

        int tmp_i = i;
        for (; tmp_i < j; tmp_i++) {
            if (a[tmp_i] > tmp)
                break;
        }
        for (int k = tmp_i; k < j; k++) {
            if (a[k] < tmp) {
                return false;
            }
        }
        return check(a, i, tmp_i-1) && check(a, tmp_i, j-1);
    }
    public boolean check(int[] a) {
        if (a.length == 0)
            return false;
        return check(a, 0, a.length-1);
    }

    public static void main(String[] args) {
        int[] a = {7,4,6,5};
        Problem23 p = new Problem23();
        System.out.println(p.check(a));
    }
}
