package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[] index = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length - 1, res);
        List<Integer> list = new ArrayList<Integer>();
        for (int i : res) {
            list.add(i);
        }
        return list;
    }

    private static void mergeSort(int[] nums, int[] index, int l, int r, int[] res) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, index, l, mid, res);
        mergeSort(nums, index, mid + 1, r, res);
        merge(nums, index, l, mid, mid + 1, r, res);
    }

    private static void merge(int[] nums, int[] index, int l1, int r1, int l2, int r2, int[] res) {
        int start = l1;
        int[] tmp = new int[r2 - l1 + 1];
        int count = 0;
        int p = 0;
        while (l1 <= r1 || l2 <= r2) {
            if (l1 > r1) {
                tmp[p++] = index[l2++];
            } else if (l2 > r2) {
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            } else if (nums[index[l1]] > nums[index[l2]]) {
                tmp[p++] = index[l2++];
                count++;
            } else {
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            }
        }
        System.arraycopy(tmp, 0, index, start + 0, tmp.length);
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }
}
