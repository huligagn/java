package com.huligang.bishi.wangyi;

import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tmp = line.split(" ");
        int[] len = new int[26];

        for (int i = 0; i < 26; i++) {
            len[i] = Integer.parseInt(tmp[i]);
        }

        char[] chars = sc.nextLine().toCharArray();


        int lines = 1, length = 0;
        for (int i = 0; i < chars.length; i++) {
            length += len[chars[i]-'a'];
            if (length > 100) {
                lines ++;
                length = len[chars[i]-'a'];
            }
        }

        System.out.print(lines + " " + length);
    }
}
