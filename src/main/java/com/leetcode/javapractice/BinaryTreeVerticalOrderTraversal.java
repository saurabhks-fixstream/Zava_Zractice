package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Map<Integer, Map<Integer, List<Integer>>> map =
                new TreeMap<Integer, Map<Integer, List<Integer>>>();
        verticalOrderHelper(root, 0, 0, map);
        for (Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            result.add(new ArrayList<Integer>());
            for (Entry<Integer, List<Integer>> e : entry.getValue().entrySet()) {
                result.get(result.size() - 1).addAll(e.getValue());
            }
        }
        return result;
    }

    public static void verticalOrderHelper(
            TreeNode root, int x, int y, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<Integer, List<Integer>>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new ArrayList<Integer>());
        }
        map.get(x).get(y).add(root.val);
        verticalOrderHelper(root.left, x - 1, y + 1, map);
        verticalOrderHelper(root.right, x + 1, y + 1, map);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(verticalOrder(root));
    }
}
