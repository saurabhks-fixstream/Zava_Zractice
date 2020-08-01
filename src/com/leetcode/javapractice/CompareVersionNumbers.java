package com.leetcode.javapractice;

public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] token1 = version1.split("\\.");
        String[] token2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < token1.length || j < token2.length) {
            String s1 = i >= token1.length ? "0" : token1[i];
            String s2 = j >= token2.length ? "0" : token2[j];
            if (Integer.valueOf(s1) < Integer.valueOf(s2)) {
                return -1;
            }
            if (Integer.valueOf(s1) > Integer.valueOf(s2)) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(compareVersion("0.1", "1.1"));

    }

}
