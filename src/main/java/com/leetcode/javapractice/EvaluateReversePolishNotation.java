package com.leetcode.javapractice;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        int a;
        int b;
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.add(stack.pop() + stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a / b);
                    break;
                case "*":
                    stack.add(stack.pop() * stack.pop());
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a - b);
                    break;
                default:
                    stack.add(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
