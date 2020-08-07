package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class CousinsinBinaryTree {

    static Map<Integer, Integer> depth;
    static Map<Integer, TreeNode> parent;

    public static boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<Integer, Integer>();
        parent = new HashMap<Integer, TreeNode>();
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);

    }

    private static void dfs(TreeNode root, TreeNode par) {
        if (root != null) {
            depth.put(root.val, par != null ? 1 + depth.get(par.val)
                    : 0);
            parent.put(root.val, par);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(isCousins(root, 5, 4));

    }

}
