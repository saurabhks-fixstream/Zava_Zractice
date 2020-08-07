package com.leetcode.javapractice;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        return isValidBSTHelper(root.left, null, val) && isValidBSTHelper(root.right, val, null);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}
