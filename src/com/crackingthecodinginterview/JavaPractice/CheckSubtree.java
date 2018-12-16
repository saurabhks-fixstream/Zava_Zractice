package com.crackingthecodinginterview.JavaPractice;

public class CheckSubtree {

    private static void getOrderString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X" + " ");
            return;
        }
        sb.append(root.val + " ");
        getOrderString(root.left, sb);
        getOrderString(root.right, sb);
    }

    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        getOrderString(t1, s1);
        getOrderString(t2, s2);
        return s1.indexOf(s2.toString()) != -1;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        t2.right = new TreeNode(1);
        t2.left = new TreeNode(2);
        System.out.println(containsTree(t1, t2));

    }

}
