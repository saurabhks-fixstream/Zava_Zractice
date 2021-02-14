package com.leetcode.javapractice;

public class ConvertBSTtoGreaterTree {

    public static TreeNode convertBST(TreeNode root) {
        convertBSTHelper(root, 0);
        return root;
    }

    public static int convertBSTHelper(TreeNode root, int val) {
        if (root == null) return val;
        int right = convertBSTHelper(root.right, val);
        int left = convertBSTHelper(root.left, root.val + right);
        root.val = root.val + right;
        return left;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(convertBST(root)));
    }
}
