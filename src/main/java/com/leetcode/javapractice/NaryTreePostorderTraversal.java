package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {

    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.add(curr);
            for (int i = 0; i < curr.children.size(); i++) {
                stack1.push(curr.children.get(i));
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
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
        System.out.println(postorder(root));
    }
}
