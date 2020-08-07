package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new TreeSet<Integer>();
        int[] result = new int[arr1.length];
        int index = 0;
        for (int arr : arr1) {
            map.put(arr, map.getOrDefault(arr, 0) + 1);
            set.add(arr);
        }
        for (int arr : arr2) {
            set.remove(arr);
            int count = map.get(arr);
            while (count-- > 0) {
                result[index++] = arr;
            }
        }
        for (int arr : set) {
            int count = map.get(arr);
            while (count-- > 0) {
                result[index++] = arr;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] arr = relativeSortArray(arr1, arr2);
        for (int a : arr) {
            System.out.print(a + ", ");
        }
    }
}
