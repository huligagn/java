package com.huligang.offer;

/**
 * 整数中1出现的次数
 * 我的想法：从1到n遍历计数（low）
 * 应该从数n本身寻找规律
 */
public class Problem30 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += find(i);
        }
        return count;
    }
    private int find(int n) {
        int count = 0;
        char[] chars = String.valueOf(n).toCharArray();
        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        int i = 1;
        int cur = 0, before = 0, after = 0;
        while((n/i) != 0) {
            cur = (n/i) % 10;
            before = n/(i*10);
            after = n - n/i*i;
            if (cur == 0) {
                count += before*i;
            } else if (cur == 1) {
                count += before*i + after + 1;
            } else {
                count += (before+1) * i;
            }

            i *= 10;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
