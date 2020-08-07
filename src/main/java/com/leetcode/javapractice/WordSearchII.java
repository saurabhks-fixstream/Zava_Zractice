package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNodeHM {

    HashMap<Character, TrieNodeHM> children = new HashMap<Character, TrieNodeHM>();
    String word = null;

    public TrieNodeHM() {}
}

public class WordSearchII {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }
        TrieNodeHM root = new TrieNodeHM();
        for (String word : words) {
            TrieNodeHM node = root;
            for (char letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNodeHM newNode = new TrieNodeHM();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, m, n, dirs, root, result);
                }
            }
        }
        return result;
    }

    private static void dfs(
            char[][] board,
            int i,
            int j,
            int m,
            int n,
            int[][] dirs,
            TrieNodeHM root,
            List<String> result) {
        char letter = board[i][j];
        TrieNodeHM currNode = root.children.get(letter);
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (currNode.children.containsKey(board[x][y])) {
                dfs(board, x, y, m, n, dirs, currNode, result);
            }
        }
        board[i][j] = letter;
        if (currNode.children.isEmpty()) {
            root.children.remove(letter);
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}
