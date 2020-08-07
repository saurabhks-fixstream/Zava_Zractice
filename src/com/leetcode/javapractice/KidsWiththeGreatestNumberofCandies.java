package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int max = Integer.MIN_VALUE;
        for (int i : candies) {
            max = Math.max(max, i);
        }
        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies) >= max ? true
                    : false);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] candies = {2, 3, 5, 1, 3};
        System.out.println(kidsWithCandies(candies, 3));

    }

}
