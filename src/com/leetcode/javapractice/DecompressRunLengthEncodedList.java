package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i += 2) {
            int count = nums[i];
            int digit = nums[i + 1];
            while (count-- > 0) {
                result.add(digit);
            }
        }
        int[] newNums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            newNums[i] = result.get(i);
        }
        return newNums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] result = decompressRLElist(nums);
        for (int i : result) {
            System.out.print(i + ", ");
        }

    }

}
