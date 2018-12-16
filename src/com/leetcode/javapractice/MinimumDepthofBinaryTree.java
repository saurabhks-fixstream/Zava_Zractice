package com.leetcode.javapractice;

public class MinimumDepthofBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (root.left == null || root.right == null) {
                if (left >= right) {
                    return left + 1;
                } else {
                    return right + 1;
                }
            }
            if (left <= right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));

    }

}
