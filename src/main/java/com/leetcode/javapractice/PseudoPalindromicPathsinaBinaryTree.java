package com.leetcode.javapractice;

public class PseudoPalindromicPathsinaBinaryTree {

    static int count;

    public static int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        pseudoPalindromicPathsHelper(root, new int[10]);
        return count;
    }

    private static void pseudoPalindromicPathsHelper(TreeNode root, int[] freq) {
        if (root == null) {
            return;
        }
        freq[root.val]++;
        if (root.left == null && root.right == null) {
            if (checkPalindrome(freq)) {
                count++;
            }
        }
        pseudoPalindromicPathsHelper(root.left, freq);
        pseudoPalindromicPathsHelper(root.right, freq);
        freq[root.val]--;
    }

    private static boolean checkPalindrome(int[] freq) {
        int odd = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root));
    }
}
