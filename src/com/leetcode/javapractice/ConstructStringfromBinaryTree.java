package com.leetcode.javapractice;

public class ConstructStringfromBinaryTree {

    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String s = String.valueOf(t.val);
        if (t.left != null) {
            s = s + "(" + tree2str(t.left) + ")";
        }
        if (t.right != null) {
            if (t.left == null) {
                s = s + "()";
            }
            s = s + "(" + tree2str(t.right) + ")";
        }
        return s;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(root));

    }

}
