package com.leetcode.javapractice;

public class SuperPalindromes {

    public static int superpalindromesInRange(String left, String right) {
        int ans = 0;
        long l = (long) Math.ceil(Math.sqrt(new Long(left)));
        long r = (long) Math.floor(Math.sqrt(new Long(right)));
        long magic = (long) Math.ceil(Math.pow(10, 4.5));
        for (long i = 1; i <= magic; i++) {
            long even = i;
            long odd = i;
            for (long j = i; j > 0; j = j / 10) {
                even = even * 10 + (j % 10);
            }
            if (l <= even && even <= r && isPalindrome(even * even)) {
                ans++;
            }
            for (long j = i / 10; j > 0; j = j / 10) {
                odd = odd * 10 + (j % 10);
            }
            if (l <= odd && odd <= r && isPalindrome(odd * odd)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    private static long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(superpalindromesInRange("4", "1000"));
    }
}
