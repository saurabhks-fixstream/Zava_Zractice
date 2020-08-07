package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<Integer>();
        int asum = 0;
        int bsum = 0;
        for (int i : A) {
            asum += i;
        }
        for (int i : B) {
            set.add(i);
            bsum += i;
        }
        int delta = (bsum - asum) / 2;
        for (int x : A) {
            int y = x + delta;
            if (set.contains(y)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 5};
        int[] B = {2, 4};
        int[] ans = fairCandySwap(A, B);
        System.out.println("[" + ans[0] + "," + ans[1] + "]");

    }

}
