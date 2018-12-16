package com.leetcode.JavaPractice;

public class ImplementstrStr {

    public static int strStr(String haystack, String needle) {
        int index = -1;
        int count = 1;
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                int length = needle.length() - 1;
                int j = 1;
                int k = i;
                while (length > 0 && k != haystack.length() - 1) {
                    if (haystack.charAt(++k) == needle.charAt(j++)) {
                        count++;
                    }
                    length--;
                }
                length = needle.length();
                if (count == length) {
                    return index;
                } else {
                    count = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String haystack = "hlyololello";
        String needle = "lyl";
        System.out.println(strStr(haystack, needle));

    }

}
