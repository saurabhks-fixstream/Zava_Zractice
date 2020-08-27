package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;

class StreamChecker {

    TrieNode root;
    Deque<Character> deque;

    public StreamChecker(String[] words) {
        this.root = new TrieNode();
        this.deque = new ArrayDeque<Character>();
        for (String word : words) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (node.children[chars[i] - 'a'] == null) {
                    node.children[chars[i] - 'a'] = new TrieNode();
                }
                node = node.children[chars[i] - 'a'];
            }
            node.isEnd = true;
        }
    }

    public boolean query(char letter) {
        this.deque.addFirst(letter);
        TrieNode node = root;
        for (char c : deque) {
            if (node.isEnd) {
                return true;
            }
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }
}

public class StreamofCharacters {

    public static void main(String[] args) {

        String[] words = {"cd", "f", "kl", "aa"};
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));
    }
}
