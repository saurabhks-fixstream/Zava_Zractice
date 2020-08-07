package com.crackingthecodinginterview.javapractice;

import java.util.Stack;

public class ValidateBST {

    public static boolean checkBST(TreeNode root) {
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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        System.out.println(checkBST(root));
    }
}
