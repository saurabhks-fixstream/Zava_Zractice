package com.leetcode.javapractice;

import java.util.List;
import java.util.Stack;

public class IncreasingOrderSearchTree {

    public static TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode newRoot = new TreeNode(0);
        TreeNode dummy = newRoot;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            dummy.right = new TreeNode(curr.val);
            dummy = dummy.right;
            curr = curr.right;
        }
        return newRoot.right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        root = increasingBST(root);
        List<Integer> list = BinaryTreeInorderTraversal.inorderTraversal(root);
        System.out.println(list);

    }

}
