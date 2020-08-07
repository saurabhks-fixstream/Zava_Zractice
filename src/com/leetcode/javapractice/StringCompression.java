package com.leetcode.javapractice;

public class StringCompression {

    public static int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        int indexAns = 0;
        int index = 0;
        while (index < chars.length) {
            char curr = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == curr) {
                index++;
                count++;
            }
            chars[indexAns++] = curr;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int length = compress(chars);
        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();

    }

}
