package com.huligang.offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class Problem21 {

    public boolean check(int[] origin, int[] target) {
        Stack<Integer> help = new Stack<>();

        int j=0;
        for (int anOrigin : origin) {
            help.push(anOrigin);
            while (!help.empty() &&help.peek() == target[j]) {
                j++;
                help.pop();
            }
        }

        return help.empty();

    }

    public static void main(String[] args) {
        int[] origin = {1,2,3,4,5};
        int[] target1 = {4,5,3,2,1};
        int[] target2 = {4,3,5,1,2};

        Problem21 p = new Problem21();
        System.out.println(p.check(origin, target1));
        System.out.println(p.check(origin, target2));
    }
}
