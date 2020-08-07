package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<Integer>());
            }
            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                result.add(map.get(groupSizes[i]));
                map.put(groupSizes[i], new ArrayList<Integer>());
            }
            map.get(groupSizes[i]).add(i);
        }
        for (List<Integer> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }
}
