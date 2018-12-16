package com.crackingthecodinginterview.javapractice;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        if (s.contains(s2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));

    }

}
