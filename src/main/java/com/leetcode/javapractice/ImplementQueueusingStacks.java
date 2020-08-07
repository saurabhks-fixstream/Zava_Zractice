package com.leetcode.javapractice;

import java.util.Stack;

public class ImplementQueueusingStacks {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueusingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {

        ImplementQueueusingStacks queue = new ImplementQueueusingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
