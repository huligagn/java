package com.huligang;

import java.util.Stack;

public class Stack_order {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int popIndex = 0;
        Stack<Integer> help = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            help.push(pushA[i]);
            while (! help.isEmpty() && help.peek() == popA[popIndex]) {
                help.pop();
                popIndex++;
            }
        }

        return help.isEmpty();
    }
}
