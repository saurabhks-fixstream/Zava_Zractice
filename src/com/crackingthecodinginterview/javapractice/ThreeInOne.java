package com.crackingthecodinginterview.javapractice;

public class ThreeInOne {

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackCapacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) {
        if (!isFull(stackNum)) {
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        } else {
            System.out.println("Stack " + stackNum + " is full.");
        }
    }

    public int pop(int stackNum) {
        int value = 0;
        if (!isEmpty(stackNum)) {
            int topIndex = indexOfTop(stackNum);
            value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
        } else {
            System.out.println("Stack " + stackNum + " is empty.");
        }
        return value;
    }

    public int peek(int stackNum) {
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public static void main(String[] args) {

        ThreeInOne stack = new ThreeInOne(8);
        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(1, 3);
        stack.push(1, 4);
        stack.push(1, 5);
        stack.push(1, 6);
        stack.push(1, 7);
        stack.push(1, 8);
        System.out.println(stack.pop(1));
        stack.push(1, 9);
        stack.push(1, 10);
        stack.push(2, 1);
        stack.push(2, 2);
        stack.push(2, 3);
        stack.push(2, 4);
        stack.push(2, 5);
        stack.push(2, 6);
        stack.push(2, 7);
        stack.push(2, 8);
        System.out.println(stack.pop(2));
        stack.push(2, 9);
        stack.push(2, 10);

    }

}
