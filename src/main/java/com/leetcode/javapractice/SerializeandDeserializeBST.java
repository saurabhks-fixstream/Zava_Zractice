package com.leetcode.javapractice;

import java.util.LinkedList;
import java.util.Queue;

class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode temp = q.poll();
                stringBuilder.append(temp.val).append(",");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        TreeNode root = null;
        String[] values = data.split(",");
        for (String value : values) {
            root = insertIntoBST(root, Integer.valueOf(value));
        }
        return root;
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        }
        return root;
    }
}

public class SerializeandDeserializeBST {

    public static void main(String[] args) {

        Codec serialize = new Codec();
        Codec deserialize = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String tree = serialize.serialize(root);
        System.out.println(tree);
        TreeNode ans = deserialize.deserialize(tree);
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(ans));
    }
}
