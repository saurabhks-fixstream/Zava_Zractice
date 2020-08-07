package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> llist = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                if (zigzag) {
                    llist.add(0, curr.val);
                } else {
                    llist.add(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            list.add(llist);
            zigzag = !zigzag;
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list = zigzagLevelOrder(root);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }
}
