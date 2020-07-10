package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthofBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {
        return widthOfBinaryTreeHelper(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    private static int widthOfBinaryTreeHelper(TreeNode root, int level, int order, List<Integer> start,
                                               List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
            end.set(level, order);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = widthOfBinaryTreeHelper(root.left, level + 1, 2 * order, start, end);
        int right = widthOfBinaryTreeHelper(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(root));

    }

}
