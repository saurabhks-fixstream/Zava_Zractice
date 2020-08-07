package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {

    public static String reformat(String s) {
        List<Character> letters = new ArrayList<Character>();
        List<Character> numbers = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(c);
            } else {
                letters.add(c);
            }
        }
        int n = numbers.size();
        int l = letters.size();
        if (Math.abs(n - l) > 1) {
            return "";
        }
        if (n >= l) {
            return build(numbers, letters);
        } else {
            return build(letters, numbers);
        }
    }

    private static String build(List<Character> a, List<Character> b) {
        StringBuilder sb = new StringBuilder();
        int m = a.size();
        int n = b.size();
        for (int i = 0; i < m && i < n; i++) {
            sb.append(a.get(i));
            sb.append(b.get(i));
        }
        while (m < n) {
            sb.append(b.get(m++));
        }
        while (n < m) {
            sb.append(a.get(n++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(reformat("a0b1c2"));
    }
}
