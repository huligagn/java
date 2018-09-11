package com.huligang.bishi.huyu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        LinkedList<TreeMap<String, Integer>> result = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            sc.nextLine();
            int Q = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] rankScore = new int[N][3];
            for (int j = 0; j < N; j++) {
                rankScore[j][0] = sc.nextInt();
                rankScore[j][1] = sc.nextInt();
                rankScore[j][2] = sc.nextInt();
            }

            int[] killScore = new int[M+1];
            for (int j = 0; j < M+1; j++) {
                killScore[j] = sc.nextInt();
            }
            int A = sc.nextInt();
            int B = sc.nextInt();

            int[] timeK = new int[Q-1];
            String[] killer = new String[Q-1];
            String[] victim = new String[Q-1];
            TreeMap<String, Integer> r = new TreeMap<>();
            for (int j = 0; j < Q-1; j++) {
                timeK[j] = sc.nextInt();
                String[] tmp = sc.nextLine().split(" ");
                killer[j] = tmp[0];
                victim[j] = tmp[1];
                r.put(tmp[0], (int)Math.random()*5000);
                r.put(tmp[1], (int)Math.random()*5000);
            }


            result.add(r);
        }

        for (TreeMap<String, Integer> r : result) {
            for (String k : r.keySet()) {
                System.out.println(k + " " + r.get(k));
            }
        }
    }

}
