package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SuggestionTrie {

    SuggestionTrie[] sub = new SuggestionTrie[26];
    List<String> suggestions = new ArrayList<String>();

}

public class SearchSuggestionsSystem {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        SuggestionTrie root = new SuggestionTrie();
        for (String product : products) {
            insert(product, root);
        }
        return searchWord(searchWord, root);
    }

    private static void insert(String product, SuggestionTrie root) {
        SuggestionTrie t = root;
        for (char c : product.toCharArray()) {
            if (t.sub[c - 'a'] == null) {
                t.sub[c - 'a'] = new SuggestionTrie();
            }
            t = t.sub[c - 'a'];
            if (t.suggestions.size() < 3) {
                t.suggestions.add(product);
            }
        }
    }

    private static List<List<String>> searchWord(String searchWord, SuggestionTrie root) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (char c : searchWord.toCharArray()) {
            if (root != null) {
                root = root.sub[c - 'a'];
            }
            if (root != null) {
                result.add(root.suggestions);
            } else {
                result.add(new ArrayList<String>());
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(suggestedProducts(products, "mouse"));

    }

}
