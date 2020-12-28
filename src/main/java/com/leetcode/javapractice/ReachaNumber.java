package com.leetcode.javapractice;

public class ReachaNumber {

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static void main(String[] args) {

        System.out.println(reachNumber(3));
    }
}
