package com.leetcode.javapractice;

public class CountCompleteTreeNodes {

    public static int countNodes(TreeNode root) {
        int height = height(root);
        if (height < 0) {
            return 0;
        }
        return height(root.right) == height - 1 ? (1 << height) + countNodes(root.right)
                : (1 << height - 1) + countNodes(root.left);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + height(root.left);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));

    }

}
