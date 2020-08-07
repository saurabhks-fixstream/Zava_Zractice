package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversalofaBinaryTree {

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer, Map<Integer, PriorityQueue<Integer>>>();
		verticalTraversalHelper(root, 0, 0, map);
		for (Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : map
				.entrySet()) {
			result.add(new ArrayList<Integer>());
			for (Entry<Integer, PriorityQueue<Integer>> e : entry.getValue()
					.entrySet()) {
				while (!e.getValue().isEmpty()) {
					result.get(result.size() - 1).add(e.getValue().poll());
				}
			}
		}
		return result;
	}

	private static void verticalTraversalHelper(TreeNode root, int x, int y,
			Map<Integer, Map<Integer, PriorityQueue<Integer>>> map) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(x)) {
			map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
		}
		if (!map.get(x).containsKey(y)) {
			map.get(x).put(y, new PriorityQueue<Integer>());
		}
		map.get(x).get(y).offer(root.val);
		verticalTraversalHelper(root.left, x - 1, y + 1, map);
		verticalTraversalHelper(root.right, x + 1, y + 1, map);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(verticalTraversal(root));

	}

}

