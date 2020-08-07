package com.leetcode.javapractice;

public class XOROperationinanArray {

    public static int xorOperation(int n, int start) {
        int xor = start;
        for (int i = 1; i < n; i++) {
            int element = start + (2 * i);
            xor ^= element;
        }
        return xor;
    }

    public static void main(String[] args) {

        System.out.println(xorOperation(5, 0));
    }
}
