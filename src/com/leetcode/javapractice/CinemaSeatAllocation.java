package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaSeatAllocation {

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] reservedSeat : reservedSeats) {
            List<Integer> list = map.getOrDefault(reservedSeat[0], new ArrayList<Integer>());
            list.add(reservedSeat[1]);
            map.put(reservedSeat[0], list);
        }
        count = (n - map.size()) * 2;
        for (List<Integer> list : map.values()) {
            boolean flag = false;
            if (!list.contains(2) && !list.contains(3) && !list.contains(4) && !list.contains(5)) {
                count++;
                flag = true;
            }
            if (!list.contains(6) && !list.contains(7) && !list.contains(8) && !list.contains(9)) {
                count++;
                flag = true;
            }
            if (!flag) {
                if (!list.contains(4) && !list.contains(5) && !list.contains(6) && !list.contains(7)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] reservedSeats = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };
        System.out.println(maxNumberOfFamilies(3, reservedSeats));
    }

}
