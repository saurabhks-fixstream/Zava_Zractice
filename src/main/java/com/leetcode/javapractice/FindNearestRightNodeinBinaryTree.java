package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNearestRightNodeinBinaryTree {

    public static TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                TreeNode temp = q.poll();
                if (temp.val == u.val) {
                    if (i + 1 == level) {
                        return null;
                    }
                    return q.poll();
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode u = new TreeNode(4);
        TreeNode result = findNearestRightNode(root, u);
        System.out.println(result.val);
    }
}
