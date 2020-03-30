package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                list.add(curr.val);
                for (Node node : curr.children) {
                    queue.offer(node);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node c = new Node(3);
        c.children.add(new Node(5));
        c.children.add(new Node(6));
        root.children.add(c);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        System.out.println(levelOrder(root));

    }

}
