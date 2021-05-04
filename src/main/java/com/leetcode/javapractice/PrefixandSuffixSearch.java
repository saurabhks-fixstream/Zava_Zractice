package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

class WordFilter {
    Map<String, Integer> map = new HashMap<String, Integer>();

    public WordFilter(String[] words) {
        for (int w = 0; w < words.length; w++) {
            for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
                for (int j = 0; j <= 10 && j <= words[w].length(); j++) {
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length() - j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}

public class PrefixandSuffixSearch {

    public static void main(String[] args) {

        String[] words = {"apple"};
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f("a", "e"));
    }
}
