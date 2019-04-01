package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> bannedWords = new HashSet<String>();
        for (String ban : banned) {
            bannedWords.add(ban);
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        int count = 0;
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0) {
                String finalWord = sb.toString();
                if (!bannedWords.contains(finalWord)) {
                    map.put(finalWord, map.getOrDefault(finalWord, 0) + 1);
                    if (map.get(finalWord) > count) {
                        ans = finalWord;
                        count = map.get(finalWord);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = { "hit" };
        System.out.println(mostCommonWord(paragraph, banned));

    }

}
