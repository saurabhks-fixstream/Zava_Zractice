package com.leetcode.javapractice;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementStackusingQueues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int n = q1.remove();
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return n;
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int n = q1.poll();
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        q1.add(n);
        return n;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {

        ImplementStackusingQueues stack = new ImplementStackusingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
