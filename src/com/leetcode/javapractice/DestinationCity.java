package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DestinationCity {

    public static String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String desc = null;
        for (List<String> path : paths) {
            String a = path.get(0);
            String b = path.get(1);
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) - 1);
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1) {
                desc = entry.getKey();
                break;
            }
        }
        return desc;
    }

    public static void main(String[] args) {

        List<List<String>> paths = new ArrayList<List<String>>();
        paths.add(Arrays.asList("B", "C"));
        paths.add(Arrays.asList("D", "B"));
        paths.add(Arrays.asList("C", "A"));
        System.out.println(destCity(paths));

    }

}
