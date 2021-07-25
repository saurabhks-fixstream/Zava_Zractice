package com.leetcode.javapractice;

import java.util.Random;

public class ShuffleanArray {

    private int[] nums;
    private Random random;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] a = nums.clone();
        for (int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        ShuffleanArray shuffleanArray = new ShuffleanArray(nums);
        int[] result = shuffleanArray.shuffle();
        System.out.print("[");
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
        result = shuffleanArray.reset();
        System.out.print("[");
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
        result = shuffleanArray.shuffle();
        System.out.print("[");
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }
}
