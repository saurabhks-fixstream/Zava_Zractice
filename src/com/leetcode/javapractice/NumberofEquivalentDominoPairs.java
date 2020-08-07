package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class NumberofEquivalentDominoPairs {

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for (int[] dominoe : dominoes) {
            int k = Math.min(dominoe[0], dominoe[1]) * 10 + Math.max(dominoe[0], dominoe[1]);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        for (int value : map.values()) {
            result += (value * (value - 1)) / 2;
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(numEquivDominoPairs(dominoes));

    }

}
