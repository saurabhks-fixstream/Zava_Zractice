package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementinSize2NArray {

    public static int repeatedNTimes(int[] A) {
        int max = Integer.MIN_VALUE;
        int value = -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int count = map.get(A[i]) + 1;
                map.put(A[i], count);
                if (count >= max) {
                    max = count;
                }
            } else {
                map.put(A[i], 1);
            }
        }
        for (int i : map.keySet()) {
            if (max == map.get(i)) {
                value = i;
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {

        int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(repeatedNTimes(A));
    }
}
