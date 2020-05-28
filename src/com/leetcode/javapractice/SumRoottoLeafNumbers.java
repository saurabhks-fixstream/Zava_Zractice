package com.leetcode.javapractice;

public class SumRoottoLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0, 0);
    }

    private static int sumNumbersHelper(TreeNode root, int total, int num) {
        if (root == null) {
            return 0;
        }
        num = (num * 10) + root.val;
        if (root.left == null && root.right == null) {
            total += num;
            return total;
        }
        return sumNumbersHelper(root.left, total, num) + sumNumbersHelper(root.right, total, num);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));

    }

}
