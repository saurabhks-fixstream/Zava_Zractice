package com.crackingthecodinginterview.javapractice;

public class StringCompression {

    public static String compressBad(String str) {
        if (str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                sb.append(prev);
                sb.append(count);
                prev = curr;
                count = 1;
            }
        }
        sb.append(prev);
        sb.append(count);
        if (str.length() <= sb.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        System.out.println(compressBad("aabbbbbbaaa"));
    }
}
