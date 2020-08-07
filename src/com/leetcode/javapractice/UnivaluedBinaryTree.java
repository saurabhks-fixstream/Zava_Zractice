package com.leetcode.javapractice;

public class UnivaluedBinaryTree {

    public static boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelper(root, root != null ? root.val
                : 0);
    }

    private static boolean isUnivalTreeHelper(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != val) {
            return false;
        }
        if (root.right != null && root.right.val != val) {
            return false;
        }
        return isUnivalTreeHelper(root.left, val) && isUnivalTreeHelper(root.right, val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        System.out.println(isUnivalTree(root));

    }

}
