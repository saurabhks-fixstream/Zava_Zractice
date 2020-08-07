package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountLargestGroup {

    public static int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= n; i++) {
            int sum = sumDigits(i);
            map.putIfAbsent(sum, new ArrayList<Integer>());
            map.get(sum).add(i);
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            if (size > max) {
                max = size;
                count = 1;
            } else if (size == max) {
                count++;
            }
        }
        return count;
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(countLargestGroup(13));
    }
}
