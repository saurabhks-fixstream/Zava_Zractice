package com.leetcode.javapractice;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        boolean done = false;
        while (!done) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    root = stack.pop();
                    if (prev != null && root.val <= prev.val) {
                        return false;
                    }
                    prev = root;
                    root = root.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));

    }

}
