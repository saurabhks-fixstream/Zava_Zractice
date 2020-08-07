package com.crackingthecodinginterview.javapractice;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<Integer> sorted = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() < temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(4);
        stack.push(6);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(8);
        stack.push(9);
        stack.push(7);
        stack.push(10);
        sort(stack);
        System.out.println(stack);
    }
}
