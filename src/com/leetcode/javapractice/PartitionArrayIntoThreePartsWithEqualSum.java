package com.leetcode.javapractice;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int part = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            part += A[i];
            if (part != sum / 3) {
                continue;
            }
            if (++count == 3) {
                return true;
            }
            part = 0;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] A = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(A));

    }

}
