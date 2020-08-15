package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

class CombinationIterator {

    List<String> combinations;
    int idx;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<String>();
        idx = 0;
        generateCombinations(
                characters.toCharArray(), 0, combinationLength, new ArrayList<Character>());
    }

    private void generateCombinations(
            char[] word, int index, int combinationLength, List<Character> list) {
        if (list.size() == combinationLength) {
            combinations.add(listToString(list));
            return;
        }
        for (int i = index; i < word.length; i++) {
            list.add(word[i]);
            generateCombinations(word, i + 1, combinationLength, list);
            list.remove(list.size() - 1);
        }
    }

    private String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String next() {
        return combinations.get(idx++);
    }

    public boolean hasNext() {
        return idx < combinations.size();
    }
}

public class IteratorforCombination {

    public static void main(String[] args) {

        CombinationIterator iterator = new CombinationIterator("abc", 2);
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
