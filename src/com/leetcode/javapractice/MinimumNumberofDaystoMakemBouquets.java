package com.leetcode.javapractice;

public class MinimumNumberofDaystoMakemBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            max = Math.max(max, day);
        }
        int start = 0;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int bouquets = getBouquets(bloomDay, mid, k);
            if (bouquets < m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int getBouquets(int[] bloomDay, int days, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
            } else {
                flowers = 0;
            }
            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets;
    }

    public static void main(String[] args) {

        int[] bloomDay = { 1, 10, 3, 10, 2 };
        System.out.println(minDays(bloomDay, 3, 1));

    }

}
