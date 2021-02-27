package com.leetcode.javapractice;

public class BrokenCalculator {

    public static int brokenCalc(int X, int Y) {
        int result = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            result++;
        }
        return result + X - Y;
    }

    public static void main(String[] args) {

        System.out.println(brokenCalc(2, 3));
    }
}
