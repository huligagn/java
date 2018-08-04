package com.huligang.bishi.wangyi;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int j = 0; j < M; j++) {
                int element = sc.nextInt();
                if (!tmp.contains(element)) {
                    tmp.add(element);
                } else {
                    tmp.remove(Integer.valueOf(element));
                    tmp.add(element);
                }
            }
            result.add(tmp);
        }

        for (int i = 0; i < T; i++) {
            LinkedList<Integer> tmp = result.get(i);
            for (int j = tmp.size() - 1; j >= 0; j--) {
                System.out.print(tmp.get(j));
                if (j != 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
