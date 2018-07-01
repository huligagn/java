package com.huligang.offer;


import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class Problem20 {


    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void push(int val) {
        if (help.empty() && val < s.peek())
            help.push(val);
        s.push(val);
    }

    public int pop() {
        if (s.peek() == help.peek()) {
            help.pop();
        }

        return s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {

        return help.peek();
    }

}
