package com.leetcode.javapractice;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1 || s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')') {
            return false;
        }
        char[] ch = new char[s.length()];
        int top = -1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                ch[++top] = c;
            } else if (top != -1 && (c == ']' || c == '}' || c == ')')) {
                if (c == ')' && ch[top] != '(') {
                    flag = false;
                }
                if (c == '}' && ch[top] != '{') {
                    flag = false;
                }
                if (c == ']' && ch[top] != '[') {
                    flag = false;
                }
                top--;
            } else {
                flag = false;
            }
        }
        if (top > -1) {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {

        System.out.println(isValid("[{[]}]"));

    }

}
