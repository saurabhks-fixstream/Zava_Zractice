package com.leetcode.JavaPractice;

public class PathSumIII {

    private static int pathSumHelper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1
                                : 0)
               + pathSumHelper(root.left, sum - root.val) + pathSumHelper(root.right, sum - root.val);
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int sum = 8;
        System.out.println(pathSum(root, sum));

    }

}
