package com.leetcode.javapractice;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            root.left = invertTree(root.left);
        }
        if (root.right != null) {
            root.right = invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root = invertTree(root);
    }
}
