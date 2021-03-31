package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {

    static List<Integer> res = new ArrayList<Integer>();
    static int i = 0;

    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    public static boolean dfs(TreeNode node, int[] v) {
        if (node == null) {
            return true;
        }
        if (node.val != v[i++]) {
            return false;
        }
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
        }
        return dfs(node.left, v) && dfs(node.right, v);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int[] voyage = {2, 1};
        System.out.println(flipMatchVoyage(root, voyage));
    }
}
