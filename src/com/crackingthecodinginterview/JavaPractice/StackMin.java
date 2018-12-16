package com.crackingthecodinginterview.JavaPractice;

import java.util.Stack;

public class StackMin {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public StackMin() {
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

        StackMin stack = new StackMin();
        stack.push(8);
        System.out.println(stack.getMin());
        stack.push(6);
        stack.push(7);
        stack.push(9);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.top());

    }

}
