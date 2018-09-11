package com.huligang.bishi.huyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem4 {

    public static boolean check(String s1, String s2) {
        boolean flag = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x')
                break;
            if (s1.charAt(i) != s2.charAt(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String find(HashMap<String, String> rule, String s) {
        for (String k : rule.keySet()) {
            if (check(k, s)) {
                return rule.get(k);
            }
        }

        return "unknown";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int M1 = sc.nextInt();
            sc.nextLine();
            HashMap<String, String> rule = new HashMap<>();
            for (int j = 0; j < M1; j++) {
                String[] tmp = sc.nextLine().split(" ");
                rule.put(tmp[0], tmp[1]);
            }
            int M2 = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < M2; j++) {
                result.add(find(rule, sc.nextLine()));
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

}
