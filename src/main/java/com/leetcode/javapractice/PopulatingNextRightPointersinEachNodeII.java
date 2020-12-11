package com.leetcode.javapractice;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

    public static NRPNode connect(NRPNode root) {
        if (root == null) {
            return root;
        }
        Queue<NRPNode> queue = new LinkedList<NRPNode>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NRPNode curr = queue.poll();
                if (i < size - 1) {
                    curr.next = queue.peek();
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

        NRPNode root = new NRPNode(1);
        root.left = new NRPNode(2);
        root.right = new NRPNode(3);
        root.left.left = new NRPNode(4);
        root.left.right = new NRPNode(5);
        root.right.right = new NRPNode(7);
        connect(root);
        System.out.println(root.levelOrder(root));
    }
}
