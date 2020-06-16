package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathSumHelper(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    private static void pathSumHelper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(list));
        }
        pathSumHelper(root.left, sum, list, result);
        pathSumHelper(root.right, sum, list, result);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));

    }

}
