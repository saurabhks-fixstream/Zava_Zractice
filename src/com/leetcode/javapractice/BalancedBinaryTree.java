package com.leetcode.javapractice;

public class BalancedBinaryTree {

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(isBalanced(root1));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        root2.left.right = new TreeNode(3);
        root2.right = new TreeNode(2);
        System.out.println(isBalanced(root2));

    }

}
