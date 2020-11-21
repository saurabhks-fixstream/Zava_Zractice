package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque<Integer>();
        Deque<StringBuilder> strStack = new ArrayDeque<StringBuilder>();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(k);
                strStack.push(sb);
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder temp = sb;
                sb = strStack.pop();
                for (k = numStack.pop(); k > 0; k--) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(decodeString("3[a]2[bc]"));
    }
}
