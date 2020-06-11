package com.leetcode.javapractice;

import java.util.Arrays;

public class ReorderDatainLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] token1 = log1.split(" ", 2);
            String[] token2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(token1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(token2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int com = token1[1].compareTo(token2[1]);
                if (com != 0) {
                    return com;
                }
                return token1[0].compareTo(token2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0
                                        : 1)
                            : -1;
        });
        return logs;
    }

    public static void main(String[] args) {

        String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        String[] result = reorderLogFiles(logs);
        for (String i : result) {
            System.out.print(i + " ");
        }

    }

}
