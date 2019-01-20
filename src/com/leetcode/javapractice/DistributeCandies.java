package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        for (int c : candies) {
            set.add(c);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {

        int[] candies = { 1, 1, 2, 2, 3, 3 };
        System.out.println(distributeCandies(candies));

    }

}
