package com.huligang;
import java.util.Stack;

/**
 *  可以输出最小值的栈，使用了辅助栈
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> helpStack = new Stack<>();

    public void push(int node) {
        mainStack.push(node);
        if (helpStack.isEmpty() || node <= helpStack.peek()){
            helpStack.push(node);
        }
    }

    public int pop() {
        int result = mainStack.pop();
        if (result == helpStack.peek()){
            helpStack.pop();
        }
        return result;
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return helpStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.min());
    }
}
