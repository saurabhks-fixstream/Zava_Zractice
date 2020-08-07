package com.leetcode.javapractice;

public class LowestCommonAncestorofaBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left_ca = lowestCommonAncestor(root.left, p, q);
        TreeNode right_ca = lowestCommonAncestor(root.right, p, q);
        if (left_ca != null && right_ca != null) {
            return root;
        }
        return (left_ca != null) ? left_ca : right_ca;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode ca = lowestCommonAncestor(root, root.left, root.left.right.right);
        if (ca != null) {
            System.out.println(ca.val);
        } else {
            System.out.println(ca);
        }
    }
}
