package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NRPNode {
    public int val;
    public NRPNode left;
    public NRPNode right;
    public NRPNode next;

    public NRPNode() {}

    public NRPNode(int _val) {
        val = _val;
    }

    public NRPNode(int _val, NRPNode _left, NRPNode _right, NRPNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public List<List<Integer>> levelOrder(NRPNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<NRPNode> q = new LinkedList<NRPNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> llist = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                NRPNode temp = q.poll();
                llist.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            list.add(llist);
        }
        return list;
    }
}

public class PopulatingNextRightPointersinEachNode {

    public static NRPNode connect(NRPNode root) {
        if (root == null) {
            return null;
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
        root.right.left = new NRPNode(6);
        root.right.right = new NRPNode(7);
        connect(root);
        System.out.println(root.levelOrder(root));
    }
}
