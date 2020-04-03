package com.leetcode.javapractice;

public class InsertintoaBinarySearchTree {

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        insertIntoBST(root, 5);
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(root));

    }

}
