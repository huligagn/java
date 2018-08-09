package com.huligang.bishi.wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class Problem5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while(sc.hasNextInt()) {
            int tmp = sc.nextInt();
            if (hashMap.get(tmp) == null) {
                hashMap.put(tmp, 1);
            } else {
                int old = hashMap.get(tmp);
                hashMap.put(tmp, old+1);
            }
        }

        int count = 0;
        for (int e : hashMap.keySet()) {
            int n = hashMap.get(e);
            count += n;
            if (n % (e + 1) == 0) {
            } else {
                count += e+1 - n%(e+1);
            }
        }

        System.out.println(count);
    }

}
