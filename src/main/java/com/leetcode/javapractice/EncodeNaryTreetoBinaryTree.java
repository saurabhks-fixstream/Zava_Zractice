package com.leetcode.javapractice;

class NaryCodec {

    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        if (root.children.size() > 0) {
            result.left = encode(root.children.get(0));
        }
        TreeNode cur = result.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return result;
    }

    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node result = new Node(root.val);
        TreeNode cur = root.left;
        while (cur != null) {
            result.children.add(decode(cur));
            cur = cur.right;
        }
        return result;
    }
}

public class EncodeNaryTreetoBinaryTree {

    public static void main(String[] args) {

        Node naryRoot = new Node(1);
        Node node1 = new Node(3);
        node1.children.add(new Node(5));
        node1.children.add(new Node(6));
        naryRoot.children.add(node1);
        naryRoot.children.add(new Node(2));
        naryRoot.children.add(new Node(4));
        NaryCodec codec = new NaryCodec();
        TreeNode encodedTreeNode = codec.encode(naryRoot);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(encodedTreeNode));
        System.out.println(NaryTreeLevelOrderTraversal.levelOrder(codec.decode(encodedTreeNode)));
    }
}
