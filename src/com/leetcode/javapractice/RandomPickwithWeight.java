package com.leetcode.javapractice;

import java.util.Random;

public class RandomPickwithWeight {

    Random random;
    int[] wSums;

    public RandomPickwithWeight(int[] w) {
        random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.wSums = w;
    }

    public int pickIndex() {
        int index = random.nextInt(wSums[wSums.length - 1]) + 1;
        int start = 0;
        int end = wSums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (wSums[mid] == index) {
                return mid;
            }
            if (wSums[mid] < index) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        int[] w = {1};
        RandomPickwithWeight r = new RandomPickwithWeight(w);
        System.out.println(r.pickIndex());

    }

}
