package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<Boolean>();
        int prev = 0;
        for (int a : A) {
            int num = prev * 2 + a;
            if (num % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
            prev = num % 5;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] A = {0, 1, 1};
        System.out.println(prefixesDivBy5(A));

    }

}
