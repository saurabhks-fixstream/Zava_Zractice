package com.leetcode.javapractice;

public class RangeSumofBST {

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        return ((low <= root.val && root.val <= high) ? root.val : 0)
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }
}
