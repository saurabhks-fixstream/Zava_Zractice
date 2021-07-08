package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceArraySizetoTheHalf {

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer>[] list = new ArrayList[arr.length + 1];
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (list[count] == null) {
                list[count] = new ArrayList<Integer>();
            }
            list[count].add(num);
        }
        int steps = 0;
        int res = 0;
        for (int i = arr.length; i > 0; i--) {
            List<Integer> cur = list[i];
            if (cur == null || cur.size() == 0) {
                continue;
            }
            for (int num : cur) {
                steps += i;
                res++;
                if (steps >= arr.length / 2) return res;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {

        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(minSetSize(arr));
    }
}
