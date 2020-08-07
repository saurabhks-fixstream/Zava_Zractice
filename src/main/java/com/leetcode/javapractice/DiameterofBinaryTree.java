package com.leetcode.javapractice;

public class DiameterofBinaryTree {

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(
                height(root.left) + height(root.right),
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
}
