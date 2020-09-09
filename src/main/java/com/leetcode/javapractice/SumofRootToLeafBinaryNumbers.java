package com.leetcode.javapractice;

public class SumofRootToLeafBinaryNumbers {

    public static int sumRootToLeaf(TreeNode root) {
        return sumRootToLeafHelper(root, 0);
    }

    private static int sumRootToLeafHelper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return sumRootToLeafHelper(root.left, val) + sumRootToLeafHelper(root.right, val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }
}
