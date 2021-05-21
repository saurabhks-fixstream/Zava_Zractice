package com.leetcode.javapractice;

public class BinaryTreeCameras {

    private static int res = 0;

    public static int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(minCameraCover(root));
    }
}
