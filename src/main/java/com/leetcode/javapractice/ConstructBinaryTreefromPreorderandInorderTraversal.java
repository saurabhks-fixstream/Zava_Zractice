package com.leetcode.javapractice;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    private static int in = 0;
    private static int pre = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private static TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(buildTree(preorder, inorder)));
    }
}
