package com.leetcode.javapractice;

public class DefanginganIPAddress {

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == '.') {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(defangIPaddr("255.100.50.0"));

    }

}
