package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {

    public static boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = k; i <= s.length() && seen.size() < 1 << k; i++) {
            seen.add(s.substring(i - k, i));
        }
        return seen.size() == 1 << k;
    }

    public static void main(String[] args) {

        System.out.println(hasAllCodes("00110110", 2));
    }
}
