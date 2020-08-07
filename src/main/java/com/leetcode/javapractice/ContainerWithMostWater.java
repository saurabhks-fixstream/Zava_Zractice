package com.leetcode.javapractice;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (i < j) {
            int min = 0;
            min = height[j] < height[i] ? height[j] : height[i];
            int temp = (j - i) * min;
            temp = Math.abs(temp);
            if (area <= temp) {
                area = temp;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }

    public static void main(String[] args) {

        int[] height = {10, 9, 8, 7, 6, 5};
        System.out.println(maxArea(height));
    }
}
