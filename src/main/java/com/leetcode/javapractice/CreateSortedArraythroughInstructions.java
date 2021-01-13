package com.leetcode.javapractice;

public class CreateSortedArraythroughInstructions {

    static int[] c;

    public static int createSortedArray(int[] instructions) {
        int result = 0;
        int n = instructions.length;
        int mod = (int) 1e9 + 7;
        c = new int[100001];
        for (int i = 0; i < n; ++i) {
            result = (result + Math.min(get(instructions[i] - 1), i - get(instructions[i]))) % mod;
            update(instructions[i]);
        }
        return result;
    }

    public static void update(int x) {
        while (x < 100001) {
            c[x]++;
            x += x & -x;
        }
    }

    public static int get(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= x & -x;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] instructions = {1, 5, 6, 2};
        System.out.println(createSortedArray(instructions));
    }
}
