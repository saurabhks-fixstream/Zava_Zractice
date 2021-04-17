package com.leetcode.javapractice;

public class BeautifulArrangementII {

    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1;
        int right = n;
        for (int i = 0; i < n; i++) {
            if (k % 2 == 0) {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
            if (k > 1) {
                k--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] result = constructArray(3, 1);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
