package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TwoSumIII {

    Map<Integer, Integer> map;

    public TwoSumIII() {
        map = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = value - entry.getKey();
            if (complement != entry.getKey()) {
                if (map.containsKey(complement)) {
                    return true;
                }
            } else {
                if (entry.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class TwoSumIIIDatastructuredesign {

    public static void main(String[] args) {

        TwoSumIII twoSum = new TwoSumIII();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
    }
}
