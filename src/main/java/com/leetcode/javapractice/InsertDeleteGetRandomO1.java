package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> locations;
    Random random;

    public RandomizedSet() {
        locations = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (locations.containsKey(val)) {
            return false;
        }
        locations.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        int index = locations.get(val);
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            locations.put(last, index);
        }
        locations.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

public class InsertDeleteGetRandomO1 {

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
