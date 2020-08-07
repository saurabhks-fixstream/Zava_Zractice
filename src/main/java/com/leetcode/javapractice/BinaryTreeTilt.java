package com.leetcode.javapractice;

public class BinaryTreeTilt {

    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curTilt = Math.abs(findSum(root.left) - findSum(root.right));
        return curTilt + findTilt(root.left) + findTilt(root.right);
    }

    public static int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + findSum(root.left) + findSum(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(findTilt(root));
    }
}
