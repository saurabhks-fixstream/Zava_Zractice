package com.leetcode.javapractice;

public class ComplementofBase10Integer {

    public static int bitwiseComplement(int N) {
        String ans = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for (char c : ans.toCharArray()) {
            if (c == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {

        System.out.println(bitwiseComplement(5));
    }
}
