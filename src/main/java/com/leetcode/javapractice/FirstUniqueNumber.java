package com.leetcode.javapractice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class FirstUnique {

    Map<Integer, Integer> map;
    int unique;

    public FirstUnique(int[] nums) {
        map = new LinkedHashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
    }

    public int showFirstUnique() {
        unique = setUnique(map);
        return unique;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }

    private int setUnique(Map<Integer, Integer> map) {
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

public class FirstUniqueNumber {

    public static void main(String[] args) {

        int[] nums = {2, 3, 5};
        FirstUnique firstUnique = new FirstUnique(nums);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(2);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());
    }
}
