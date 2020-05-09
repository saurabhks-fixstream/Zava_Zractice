package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<String>(map.keySet());
        Collections.sort(result, (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2)
                                                                             : map.get(w2) - map.get(w1));
        return result.subList(0, k);
    }

    public static void main(String[] args) {

        String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        System.out.println(topKFrequent(words, 4));

    }

}
