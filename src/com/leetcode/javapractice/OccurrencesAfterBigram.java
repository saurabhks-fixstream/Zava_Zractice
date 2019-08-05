package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<String>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {

        String[] result = findOcurrences("alice is a good girl she is a good student", "a", "good");
        for (String str : result) {
            System.out.print(str + ",");
        }

    }

}
