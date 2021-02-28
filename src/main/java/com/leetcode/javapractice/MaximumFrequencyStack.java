package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> group;
    int maxFrequency;

    public FreqStack() {
        frequency = new HashMap<Integer, Integer>();
        group = new HashMap<Integer, Stack<Integer>>();
        maxFrequency = 0;
    }

    public void push(int x) {
        int f = frequency.getOrDefault(x, 0) + 1;
        frequency.put(x, f);
        if (f > maxFrequency) {
            maxFrequency = f;
        }
        group.computeIfAbsent(f, z -> new Stack<Integer>()).push(x);
    }

    public int pop() {
        int x = group.get(maxFrequency).pop();
        frequency.put(x, frequency.get(x) - 1);
        if (group.get(maxFrequency).isEmpty()) {
            maxFrequency--;
        }
        return x;
    }
}

public class MaximumFrequencyStack {

    public static void main(String[] args) {

        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
