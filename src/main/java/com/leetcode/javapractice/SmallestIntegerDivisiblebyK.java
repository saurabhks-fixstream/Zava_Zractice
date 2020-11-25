package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisiblebyK {

    public static int smallestRepunitDivByK(int K) {
        int result = 0;
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 3, 7, 9));
        if (!set.contains(K % 10)) {
            return -1;
        }
        for (int i = 1; i <= K; i++) {
            result = (result * 10 + 1) % K;
            if (result == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(smallestRepunitDivByK(1));
    }
}
