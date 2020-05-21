package com.leetcode.javapractice;

import java.util.Stack;

public class KthSmallestElementinaBST {

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode temp = stack.pop();
            k--;
            if (k == 0) {
                return temp.val;
            }
            TreeNode right = temp.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest(root, 1));

    }

}
