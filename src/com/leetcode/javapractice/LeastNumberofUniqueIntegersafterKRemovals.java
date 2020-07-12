package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class LeastNumberofUniqueIntegersafterKRemovals {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] count = new int[arr.length + 1];
        for (int v : map.values()) {
            count[v]++;
        }
        int remaining = map.size();
        int idx = 1;
        while (k > 0) {
            if (k - idx * count[idx] >= 0) {
                k -= idx * count[idx];
                remaining -= count[idx++];
            } else {
                return remaining - k / idx;
            }
        }
        return remaining;
    }

    public static void main(String[] args) {

        int[] arr = { 5, 5, 4 };
        System.out.println(findLeastNumOfUniqueInts(arr, 1));

    }

}
