package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);
        return pathSumHelper(root, 0, sum, preSum);
    }

    private static int pathSumHelper(TreeNode root, int curr, int sum, Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        curr += root.val;
        int numOfPaths = preSum.getOrDefault(curr - sum, 0);
        preSum.put(curr, preSum.getOrDefault(curr, 0) + 1);
        int res =
                numOfPaths + pathSumHelper(root.left, curr, sum, preSum) + pathSumHelper(root.right, curr, sum, preSum);
        preSum.put(curr, preSum.get(curr) - 1);
        return res;
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
