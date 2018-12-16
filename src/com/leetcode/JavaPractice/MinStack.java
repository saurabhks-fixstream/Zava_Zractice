package com.leetcode.JavaPractice;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || x <= getMin()) {
            s2.push(x);
        }
    }

    public void pop() {
        if (s1.peek() == getMin()) {
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MAX_VALUE);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

}
