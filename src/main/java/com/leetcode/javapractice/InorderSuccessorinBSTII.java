package com.leetcode.javapractice;

public class InorderSuccessorinBSTII {

    public static TreeNode inorderSuccessor(TreeNode node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.parent = root;
        root.right = new TreeNode(3);
        root.right.parent = root;
        System.out.println(inorderSuccessor(root.left).val);
    }
}
