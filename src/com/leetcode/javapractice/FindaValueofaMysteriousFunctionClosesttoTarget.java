package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class FindaValueofaMysteriousFunctionClosesttoTarget {

    public static int closestToTarget(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> tmp = new HashSet<Integer>();
            tmp.add(arr[i]);
            for (int n : set) {
                tmp.add(n & arr[i]);
            }
            for (int n : tmp) {
                min = Math.min(min, Math.abs(n - target));
            }
            set = tmp;
        }
        return min;
    }

    public static void main(String[] args) {

        int[] arr = {9, 12, 3, 7, 15};
        System.out.println(closestToTarget(arr, 5));

    }

}
