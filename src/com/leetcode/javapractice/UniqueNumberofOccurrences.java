package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int value : map.values()) {
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));

    }

}
