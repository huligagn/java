package com.huligang.prcatice;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumberMultiply {

    public static void convertdata(char data[], int len) {
        // 高低位对调
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int len = len1 + len2 + 3;

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        convertdata(c1, len1);
        convertdata(c2, len2);

        int[] c = new int[len];

        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++) {
                c[i + j] += Integer.parseInt(String.valueOf(c1[i])) * Integer.parseInt(String.valueOf(c2[j]));
            }
        }
//        System.out.println(Arrays.toString(c));

        int m = 0;
        // 进位处理
        for (m = 0; m < len; m++) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if (carry > 0)
                c[m + 1] += carry;
        }
        // 找到最高位（避免前导0）
        for (m = len - 1; m >= 0;) {
            if (c[m] > 0)
                break;
            m--;
        }
        // 由最高位开始打印乘积
        for (int n = 0; n <= m; n++) {
            System.out.print(c[m - n]);
        }
        System.out.println();
    }
}
