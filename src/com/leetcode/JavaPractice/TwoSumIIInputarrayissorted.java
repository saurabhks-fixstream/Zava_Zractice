package com.leetcode.JavaPractice;

public class TwoSumIIInputarrayissorted {

    public static int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                index[0] = i + 1;
                index[1] = j + 1;
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] numbers = { 2, 7, 11, 15, 19, 20 };
        int target = 27;
        int[] result = twoSum(numbers, target);
        System.out.print("[");
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println("]");

    }

}
