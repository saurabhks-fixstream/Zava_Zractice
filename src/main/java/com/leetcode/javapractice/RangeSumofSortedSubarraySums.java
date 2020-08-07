package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumofSortedSubarraySums {

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        int result = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        while (left <= right) {
            result = (result % mod + list.get(left - 1)) % mod;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(rangeSum(nums, 4, 1, 5));
    }
}
