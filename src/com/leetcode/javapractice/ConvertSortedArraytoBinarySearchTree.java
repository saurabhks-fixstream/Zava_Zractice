package com.leetcode.javapractice;

public class ConvertSortedArraytoBinarySearchTree {

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, low, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, high);
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums.length == 0 || nums == null) {
            return root;
        }
        int low = 0;
        int high = nums.length - 1;
        root = sortedArrayToBSTHelper(nums, low, high);
        return root;
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        traverse(root);
        System.out.println();

    }

}
