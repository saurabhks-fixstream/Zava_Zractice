package com.leetcode.javapractice;

public class BitwiseANDofNumbersRange {

    public static int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            step++;
        }
        return m << step;
    }

    public static void main(String[] args) {

        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
