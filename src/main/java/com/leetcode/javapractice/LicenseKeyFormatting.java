package com.leetcode.javapractice;

public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) {
            return S;
        }
        S = S.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        int len = S.length() - 1;
        int j = K;
        while (len >= 0) {
            if (j != 0 && S.charAt(len) != '-') {
                stringBuilder.append(S.charAt(len));
                j--;
            }
            if (j == 0 && len != 0) {
                stringBuilder.append('-');
                j = K;
            }
            len--;
        }
        if (stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '-') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
