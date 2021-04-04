package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LargestUniqueNumber {

    public static int largestUniqueNumber(int[] A) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = Math.max(result, entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] A = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        System.out.println(largestUniqueNumber(A));
    }
}
