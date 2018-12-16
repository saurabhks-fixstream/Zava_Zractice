package com.crackingthecodinginterview.javapractice;

public class FirstCommonAncestor {

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left_ca = commonAncestor(root.left, p, q);
        TreeNode right_ca = commonAncestor(root.right, p, q);
        if (left_ca != null && right_ca != null) {
            return root;
        }
        return (left_ca != null) ? left_ca
                                 : right_ca;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode ca = commonAncestor(root, root.left, root.left.right.right);
        if (ca != null) {
            System.out.println(ca.val);
        } else {
            System.out.println(ca);
        }

    }

}
