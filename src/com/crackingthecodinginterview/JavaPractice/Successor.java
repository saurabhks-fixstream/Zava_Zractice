package com.crackingthecodinginterview.JavaPractice;

public class Successor {

    public static TreeNode inorderSucc(TreeNode root, TreeNode n) {
        if (root == null || n == null) {
            return null;
        }
        TreeNode succ = null;
        if (n.right != null) {
            TreeNode temp = n.right;
            while (temp != null) {
                succ = temp;
                temp = temp.left;
            }
            return succ;
        }
        while (root != null) {
            if (n.val < root.val) {
                succ = root;
                root = root.left;
            } else if (n.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return succ;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode succ = inorderSucc(root, root.left);
        if (succ == null) {
            System.out.println(succ);
        } else {
            System.out.println(succ.val);
        }

    }

}
