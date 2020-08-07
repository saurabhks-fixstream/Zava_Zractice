package com.leetcode.javapractice;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int d1 = i < 0 ? 0 : a.charAt(i--) - '0';
            int d2 = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = d1 + d2 + carry;
            if (sum > 1) {
                carry = 1;
                sb.append(sum == 2 ? "0" : "1");
            } else {
                carry = 0;
                sb.append(sum);
            }
        }
        if (carry == 1) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
    }
}
