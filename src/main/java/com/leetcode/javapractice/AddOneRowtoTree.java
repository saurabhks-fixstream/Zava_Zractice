package com.leetcode.javapractice;

public class AddOneRowtoTree {

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 2) {
            TreeNode newroot = new TreeNode(v);
            if (d == 0) newroot.right = root;
            else newroot.left = root;
            return newroot;
        }
        if (root == null) return null;
        root.left = addOneRow(root.left, v, d == 2 ? 1 : d - 1);
        root.right = addOneRow(root.right, v, d == 2 ? 0 : d - 1);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(addOneRow(root, 1, 2)));
    }
}
