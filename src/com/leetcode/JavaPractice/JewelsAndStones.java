package com.leetcode.JavaPractice;

public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            String s = String.valueOf(S.charAt(i));
            if (J.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {

        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

    }

}
