package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, List<Character>> treeMap = new TreeMap<Integer, List<Character>>(Comparator.reverseOrder());
        for (Entry<Character, Integer> entry : map.entrySet()) {
            int key = entry.getValue();
            if (!treeMap.containsKey(key)) {
                treeMap.put(key, new ArrayList<Character>());
            }
            treeMap.get(key).add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (Entry<Integer, List<Character>> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            List<Character> value = entry.getValue();
            for (char c : value) {
                for (int i = 0; i < key; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(frequencySort("tree"));

    }

}
