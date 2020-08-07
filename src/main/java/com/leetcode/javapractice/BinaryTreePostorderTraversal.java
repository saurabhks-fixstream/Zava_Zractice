package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }
}
