package com.crackingthecodinginterview.JavaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {

    private List<Stack<Integer>> stacks = new ArrayList<>();
    public int capacity;
    public int size;
    Stack<Integer> stack;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public void push(int value) {
        if (size == capacity || size == 0) {
            size = 0;
            stack = new Stack<Integer>();
            stacks.add(stack);
        }
        stack.push(value);
        size++;
    }

    public int pop() {
        if (size == 1) {
            size = capacity;
        } else {
            size--;
        }
        return stacks.get(stacks.size() - 1).pop();
    }

    public int popAt(int index) {
        int value = 0;
        if (index == stacks.size() - 1) {
            value = stacks.get(index).pop();
            if (stacks.get(index).isEmpty()) {
                stacks.remove(index);
            }
        } else {
            value = stacks.get(index).pop();
        }
        return value;
    }

    public static void main(String[] args) {

        StackOfPlates plates = new StackOfPlates(5);
        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);
        plates.push(5);
        plates.push(6);
        plates.push(7);
        plates.push(8);
        plates.push(9);
        plates.push(10);
        plates.push(11);
        plates.push(12);
        plates.push(13);
        System.out.println(plates.stacks);
        System.out.println(plates.pop());
        System.out.println(plates.stacks);
        System.out.println(plates.popAt(2));
        System.out.println(plates.stacks);
        System.out.println(plates.popAt(2));
        System.out.println(plates.stacks);
        System.out.println(plates.popAt(0));
        System.out.println(plates.stacks);

    }

}
