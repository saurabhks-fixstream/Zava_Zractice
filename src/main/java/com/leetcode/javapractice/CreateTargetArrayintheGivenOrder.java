package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayintheGivenOrder {

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int i = 0;
        while (i < index.length) {
            result[i] = list.get(i);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] result = createTargetArray(nums, index);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
