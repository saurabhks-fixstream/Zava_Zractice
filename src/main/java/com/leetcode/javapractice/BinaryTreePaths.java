package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private static void binaryTreePathsHelper(TreeNode root, StringBuilder sb, List<String> list) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        } else {
            sb.append("->");
            binaryTreePathsHelper(root.left, sb, list);
            binaryTreePathsHelper(root.right, sb, list);
        }
        sb.setLength(len);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        binaryTreePathsHelper(root, sb, list);
        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }
}
