package com.huligang.bishi.pinduoduo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 从0点到达n点，第s步走s距离，允许反向，求走到n点的最少步数
 * 例如输入6，输出3（第一步+1，第二步+2，第三步+3）
 *
 * 总结：这个题还要想想，只有30%通过。。。
 */
public class Problem3 {

    public static void main(String[]  args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, HashMap<Integer, Integer>> result = new HashMap<>();

        HashMap<Integer, Integer> tmp = new HashMap<>();
        tmp.put(1,1);
        tmp.put(-1,1);
        result.put(1, tmp);

        int i = 2;
        while(true) {
            tmp = result.get(i-1);
            HashMap<Integer, Integer> temp = new HashMap<>();
            for (int k : tmp.keySet()) {
                if (k == n) {
                    System.out.println(i-1);
                    return;
                }
                temp.put(k-i,1);
                temp.put(k+i, 1);
                result.put(i, temp);
            }

            i++;
        }
    }
}
