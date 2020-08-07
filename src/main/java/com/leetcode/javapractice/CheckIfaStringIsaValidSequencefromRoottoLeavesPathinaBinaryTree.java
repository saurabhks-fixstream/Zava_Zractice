package com.leetcode.javapractice;

public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequenceHelper(root, arr, 0);
    }

    private static boolean isValidSequenceHelper(TreeNode root, int[] arr, int index) {
        if (root == null) {
            return false;
        }
        if (root.val != arr[index]) {
            return false;
        }
        if (index == arr.length - 1) {
            return root.left == null && root.right == null;
        }
        return isValidSequenceHelper(root.left, arr, index + 1)
                || isValidSequenceHelper(root.right, arr, index + 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        int[] arr = {0, 1, 0, 1};
        System.out.println(isValidSequence(root, arr));
    }
}
