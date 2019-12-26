package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (diff >= arr[i + 1] - arr[i]) {
                diff = arr[i + 1] - arr[i];
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (arr[i + 1] - arr[i] == diff) {
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = { 40, 11, 26, 27, -20 };
        System.out.println(minimumAbsDifference(arr));

    }

}
