package com.huligang.offer;

import java.util.Stack;

/**
 * 用两个栈来实现队列
 */
public class Problem5 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public void push(int node) {
        stack.push(node);
    }

    public int pop() {
        if (stack.empty())
            return Integer.MIN_VALUE;
        while(!stack.empty())
            help.push(stack.pop());
        int target = help.pop();

        while(!help.empty())
            stack.push(help.pop());

        return target;
    }


    public static void main(String[] args) {
        Problem5 p = new Problem5();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
    }

}
