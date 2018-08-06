package com.huligang.algs4;

import java.util.Scanner;
import java.util.Stack;

/**
 * 整个算术表达式必须以（）包起来
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.next();
            switch (s) {
                case "(":
                    ops.push(s);
                    break;
                case "+":
                    ops.push(s);
                    break;
                case "-":
                    ops.push(s);
                    break;
                case "*":
                    ops.push(s);
                    break;
                case "/":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case "+":
                            v = vals.pop() + v;
                            break;
                        case "-":
                            v = vals.pop() - v;
                            break;
                        case "*":
                            v = vals.pop() * v;
                            break;
                        case "/":
                            v = vals.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                    }
                    vals.push(v);
                    break;
                default:
                    vals.push(Double.parseDouble(s));
                    break;
            }
        }
        System.out.println(vals.pop());
    }
}
