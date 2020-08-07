package com.leetcode.javapractice;

public class ConstructBinarySearchTreefromPreorderTraversal {

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int n : preorder) {
            root = insertIntoBST(root, n);
        }
        return root;
    }

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

        int[] preorder = {8, 5, 1, 7, 10, 12};
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(bstFromPreorder(preorder)));
    }
}
