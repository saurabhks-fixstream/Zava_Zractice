package com.leetcode.javapractice;

import java.util.Arrays;

public class ThreeEqualParts {

    public static int[] threeEqualParts(int[] arr) {
        int numOnes = Arrays.stream(arr).sum();
        if (numOnes % 3 != 0) {
            return new int[] {-1, -1};
        }
        int numOnesPerPart = numOnes / 3;
        if (numOnesPerPart == 0) {
            return new int[] {0, arr.length - 1};
        }
        int leftPtr = locateOne(arr, 1);
        int midPtr = locateOne(arr, numOnesPerPart + 1);
        int rightPtr = locateOne(arr, numOnesPerPart * 2 + 1);
        while (rightPtr < arr.length) {
            if (arr[leftPtr] == arr[midPtr] && arr[rightPtr] == arr[midPtr]) {
                leftPtr++;
                midPtr++;
                rightPtr++;
            } else {
                return new int[] {-1, -1};
            }
        }
        return new int[] {leftPtr - 1, midPtr};
    }

    private static int locateOne(int[] arr, int targetOne) {
        int countOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                countOne++;
                if (countOne == targetOne) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 0, 1};
        int[] result = threeEqualParts(arr);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
