package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {

    public static int numFactoredBinaryTrees(int[] arr) {
        long result = 0L;
        long mod = (long) 1e9 + 7;
        Arrays.sort(arr);
        HashMap<Integer, Long> dp = new HashMap<Integer, Long>();
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    dp.put(
                            arr[i],
                            (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % mod);
                }
                result = (result + dp.get(arr[i])) % mod;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4};
        System.out.println(numFactoredBinaryTrees(arr));
    }
}
