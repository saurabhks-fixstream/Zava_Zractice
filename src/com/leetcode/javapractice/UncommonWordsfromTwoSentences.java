package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsfromTwoSentences {

    public static String[] uncommonFromSentences(String A, String B) {
        A += ".";
        B += ".";
        Map<String, Integer> a = new HashMap<String, Integer>();
        Map<String, Integer> b = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (char ch : A.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                a.put(sb.toString(), a.getOrDefault(sb.toString(), 0) + 1);
                sb = new StringBuilder();
            }
        }
        for (char ch : B.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                b.put(sb.toString(), b.getOrDefault(sb.toString(), 0) + 1);
                sb = new StringBuilder();
            }
        }
        for (String s : a.keySet()) {
            if (a.get(s) == 1 && !b.containsKey(s)) {
                result.add(s);
            }
        }
        for (String s : b.keySet()) {
            if (b.get(s) == 1 && !a.containsKey(s)) {
                result.add(s);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {

        String[] result = uncommonFromSentences("this apple is sweet", "this apple is sour");
        for (String s : result) {
            System.out.print(s + " ");
        }

    }

}
