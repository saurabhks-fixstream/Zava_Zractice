package com.leetcode.javapractice;

import java.util.Stack;

public class ConstructBinaryTreefromString {

    public static TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0, j = i; i < s.length(); i++, j = i) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (c >= '0' && c <= '9' || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode currentNode = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = currentNode;
                    } else {
                        parent.left = currentNode;
                    }
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

    public static void main(String[] args) {

        TreeNode root = str2tree("4(2(3)(1))(6(5))");
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(root));
    }
}
