package com.leetcode.javapractice;

class NumArray {

    private int[] nums;
    private int[] bit;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        while (i <= n) {
            bit[i] += val;
            i += (i & -i);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    private int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}

public class RangeSumQueryMutable {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
