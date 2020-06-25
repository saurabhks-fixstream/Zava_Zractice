package com.leetcode.javapractice;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (start < end) {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            if (leftMax < rightMax) {
                water += leftMax - height[start];
                start++;
            } else {
                water += rightMax - height[end];
                end--;
            }
        }
        return water;
    }

    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));

    }

}
