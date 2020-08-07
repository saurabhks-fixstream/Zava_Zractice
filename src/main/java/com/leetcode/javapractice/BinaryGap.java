package com.leetcode.javapractice;

public class BinaryGap {

    public static int binaryGap(int N) {
        int last = -1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) > 0) {
                if (last >= 0) {
                    result = Math.max(result, i - last);
                }
                last = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(binaryGap(13));
    }
}
