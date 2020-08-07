package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int idx = k / factorial[n - i];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k -= idx * factorial[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(getPermutation(3, 3));
    }
}
