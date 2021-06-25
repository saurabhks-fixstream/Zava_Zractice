package com.leetcode.javapractice;

import java.util.Arrays;

public class MaximumUnitsonaTruck {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        for (int[] box : boxTypes) {
            while (truckSize > 0 && box[0] > 0) {
                result += box[1];
                truckSize--;
                box[0]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        System.out.println(maximumUnits(boxTypes, 4));
    }
}
