package com.leetcode.javapractice;

class VersionControl {

    public static boolean isBadVersion(int version) {
        if (version >= 1702766719) {
            return true;
        } else {
            return false;
        }
    }

}

public class FirstBadVersion extends VersionControl {

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + ((end - start) / 2);
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        System.out.println(firstBadVersion(2126753390));

    }

}
