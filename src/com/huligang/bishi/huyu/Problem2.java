package com.huligang.bishi.huyu;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String SPECIAL = "!@#$%^&*()_+-=[]{},.<>/?";
        String[] WTF = {"password", "admin", "qwerty", "hello", "iloveyou", "112233"};

        String[] result = new String[N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            if (s.length() < 8) {
                result[i] = "no";
                continue;
            }
            char[] tmp = s.toCharArray();
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;
            boolean flag4 = true;
            for (char aTmp : tmp) {
                if (aTmp >= 'a' && aTmp <= 'z') {
                    flag1 = false;
                } else if (aTmp >= 'A' && aTmp <= 'Z') {
                    flag2 = false;
                } else if (aTmp >= '0' && aTmp <= '9') {
                    flag3 = false;
                } else if (SPECIAL.indexOf(aTmp) != -1) {
                    flag4 = false;
                }
            }
            if (flag1 || flag2 || flag3 || flag4) {
                result[i] = "no";
                continue;
            }

            // 等差数字
            flag1 = false;
            for (int j = 1; j < tmp.length-1; j++) {
                if (((tmp[j-1] + tmp[j+1]) == tmp[j]*2 && tmp[j-1] < tmp[j] && "12345678".indexOf(tmp[j]) != -1)) {
                    result[i] = "no";
                    flag1 = true;
                    break;
                }
            }
            if (flag1) {
                continue;
            }

            // 连续小写字母
            flag1 = false;
            for (int j = 1; j < tmp.length-1; j++) {
                if ((tmp[j] - tmp[j-1]) == 1 && (tmp[j+1] - tmp[j]) == 1 && tmp[j] > 'a' && tmp[j] < 'z') {
                    result[i] = "no";
                    flag1 = true;
                    break;
                }
            }
            if (flag1) {
                continue;
            }

            // 连续大写字母
            flag1 = false;
            for (int j = 1; j < tmp.length-1; j++) {
                if ((tmp[j] - tmp[j-1]) == 1 && (tmp[j+1] - tmp[j]) == 1 && tmp[j] > 'A' && tmp[j] < 'Z') {
                    result[i] = "no";
                    flag1 = true;
                    break;
                }
            }
            if (flag1) {
                continue;
            }



            flag1 = false;
            for (String e : WTF) {
                if (s.contains(e)) {
                    result[i] = "no";
                    flag1 = true;
                    break;
                }
            }
            if (flag1) {
                continue;
            }
            result[i] = "yes";
        }

        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
