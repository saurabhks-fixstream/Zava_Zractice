package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedinanArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove((Integer) nums[i]);
            }
        }
        for (int i : set) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.print("[");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println("]");

    }

}
