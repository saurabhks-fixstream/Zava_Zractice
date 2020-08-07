package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {

    List<Integer> nums;
    Map<Integer, Set<Integer>> locations;
    Random random;

    public RandomizedCollection() {
        locations = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean contains = locations.containsKey(val);
        if (!contains) {
            locations.put(val, new HashSet<Integer>());
        }
        locations.get(val).add(nums.size());
        nums.add(val);
        return !contains;
    }

    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        int index = locations.get(val).iterator().next();
        locations.get(val).remove(index);
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            locations.get(last).remove(nums.size() - 1);
            locations.get(last).add(index);
        }
        if (locations.get(val).isEmpty()) {
            locations.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

public class InsertDeleteGetRandomO1Duplicatesallowed {

    public static void main(String[] args) {

        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(2));
        System.out.println(collection.getRandom());
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
    }
}
