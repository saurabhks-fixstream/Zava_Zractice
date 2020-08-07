package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodinTheCity {

    public static int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lastOccurrence = new HashMap<Integer, Integer>();
        TreeSet<Integer> dryDays = new TreeSet<Integer>();
        int[] result = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                result[i] = 1;
            } else {
                result[i] = -1;
                if (lastOccurrence.containsKey(rains[i])) {
                    Integer dryDay = dryDays.ceiling(lastOccurrence.get(rains[i]));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    result[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }
                lastOccurrence.put(rains[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] rains = {1, 2, 3, 4};
        int[] result = avoidFlood(rains);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
