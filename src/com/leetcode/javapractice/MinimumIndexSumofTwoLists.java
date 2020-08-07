package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumIndexSumofTwoLists {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                map.put(list2[i], sum);
                if (sum <= min) {
                    min = sum;
                }
                set.add(list2[i]);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) == min && set.contains(s)) {
                list.add(s);
            }
        }
        String[] strings = new String[list.size()];
        int i = 0;
        for (String s : list) {
            strings[i++] = s;
        }
        return strings;
    }

    public static void main(String[] args) {

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] strings = findRestaurant(list1, list2);
        for (String s : strings) {
            System.out.print(s + " ");
        }

    }

}
