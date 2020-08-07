package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words_perfect = new HashSet<String>();
        Map<String, String> words_cap = new HashMap<String, String>();
        Map<String, String> words_vow = new HashMap<String, String>();
        for (String word : wordlist) {
            words_perfect.add(word);
            String word_low = word.toLowerCase();
            words_cap.putIfAbsent(word_low, word);
            char[] chars = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (isVowel(c)) {
                    sb.append('_');
                } else {
                    sb.append(c);
                }
            }
            words_vow.putIfAbsent(sb.toString().toLowerCase(), word);
        }
        String[] result = new String[queries.length];
        int i = 0;
        for (String query : queries) {
            result[i] = "";
            if (words_perfect.contains(query)) {
                result[i] = query;
            } else if (words_cap.keySet().contains(query.toLowerCase())) {
                result[i] = words_cap.get(query.toLowerCase());
                ;
            } else {
                char[] chars = query.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (char c : chars) {
                    if (isVowel(c)) {
                        sb.append('_');
                    } else {
                        sb.append(c);
                    }
                }
                if (words_vow.keySet().contains(sb.toString().toLowerCase())) {
                    result[i] = words_vow.get(sb.toString().toLowerCase());
                }
            }
            i++;
        }
        return result;
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {

        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        String[] result = spellchecker(wordlist, queries);
        for (String s : result) {
            System.out.print(s + " ");
        }

    }

}
