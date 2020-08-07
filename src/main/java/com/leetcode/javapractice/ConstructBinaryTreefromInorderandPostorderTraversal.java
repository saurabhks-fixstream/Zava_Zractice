package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    static int post_idx;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        post_idx = postorder.length - 1;
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, idx_map);
    }

    private static TreeNode buildTreeHelper(
            int[] inorder, int in_left, int in_right, int[] postorder, Map<Integer, Integer> idx_map) {
        if (in_left > in_right) {
            return null;
        }
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        post_idx--;
        root.right = buildTreeHelper(inorder, index + 1, in_right, postorder, idx_map);
        root.left = buildTreeHelper(inorder, in_left, index - 1, postorder, idx_map);
        return root;
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(root));
    }
}
