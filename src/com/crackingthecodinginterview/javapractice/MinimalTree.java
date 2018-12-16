package com.crackingthecodinginterview.javapractice;

public class MinimalTree {

    private static TreeNode createMinimalBSTHelper(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = createMinimalBSTHelper(array, start, mid - 1);
        root.right = createMinimalBSTHelper(array, mid + 1, end);
        return root;
    }

    public static TreeNode createMinimalBST(int[] array) {
        TreeNode root = null;
        if (array.length == 0 || array == null) {
            return root;
        }
        int start = 0;
        int end = array.length - 1;
        root = createMinimalBSTHelper(array, start, end);
        return root;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {

        int[] array = { 0, 2, 3, 6, 7, 9, 12, 17, 21 };
        TreeNode root = createMinimalBST(array);
        traverse(root);

    }

}
