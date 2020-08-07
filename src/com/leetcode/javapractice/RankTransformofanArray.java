package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformofanArray {

    public static int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rank = 1;
        for (int i : clone) {
            if (!map.containsKey(i)) {
                map.put(i, rank++);
            }
        }
        rank = 0;
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[rank++]);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] result = arrayRankTransform(arr);
        for (int i : result) {
            System.out.print(i + ",");
        }

    }

}
