package com.huligang.bishi.pinduoduo;

import java.util.Scanner;

/**
 * 求数组的最小构造子串，例如输入abcabcabcabc，输出abc
 *
 * 总结：自己逻辑不清晰！！！！
 */
public class Problem2 {

    public static boolean check(String s, int n) {
        for (int i = 0; i < n; i++) {
            char tmp = s.charAt(i);
            for (int j = n+i; j < s.length(); j += n) {
                if (s.charAt(j) != tmp)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int len = str.length();

        int i;
        for (i = 1; i <= len/2 + 1; i++) {
            if (len % i == 0){
                if (check(str, i))
                    break;
            }
        }

        if (i==(len/2+1))
            System.out.println(str);
        else
            System.out.println(str.substring(0,i));
    }
}
