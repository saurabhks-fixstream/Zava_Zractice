package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node c = new Node(3);
        c.children.add(new Node(5));
        c.children.add(new Node(6));
        root.children.add(c);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        System.out.println(preorder(root));

    }

}
