package com.leetcode.javapractice;

public class NumberofSubstringsWithOnly1s {

    public static int numSub(String s) {
        int mod = 1000000007;
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count = 0;
            }
            result = (result + count) % mod;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(numSub("0110111"));

    }

}
