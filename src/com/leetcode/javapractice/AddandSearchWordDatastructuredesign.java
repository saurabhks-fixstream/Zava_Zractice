package com.leetcode.javapractice;

class WDTrieNode {

	WDTrieNode[] children;
	boolean isEnd;

	public WDTrieNode() {
		this.children = new WDTrieNode[26];
		this.isEnd = false;
	}

}

class WordDictionary {

	WDTrieNode root;

	public WordDictionary() {
		root = new WDTrieNode();
	}

	public void addWord(String word) {
		WDTrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new WDTrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	private boolean match(char[] word, int idx, WDTrieNode node) {
		if (idx == word.length) {
			return node.isEnd;
		}
		if (word[idx] == '.') {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null && match(word, idx + 1,
						node.children[i])) {
					return true;
				}
			}
		} else {
			return node.children[word[idx] - 'a'] != null && match(word,
					idx + 1, node.children[word[idx] - 'a']);
		}
		return false;
	}

}

public class AddandSearchWordDatastructuredesign {

	public static void main(String[] args) {

		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));

	}

}
