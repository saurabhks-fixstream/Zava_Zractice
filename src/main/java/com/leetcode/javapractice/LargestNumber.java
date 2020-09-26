package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(
                strings,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String order1 = o1 + o2;
                        String order2 = o2 + o1;
                        return order2.compareTo(order1);
                    }
                });
        if (strings[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        int[] nums = {10, 2};
        System.out.println(largestNumber(nums));
    }
}
