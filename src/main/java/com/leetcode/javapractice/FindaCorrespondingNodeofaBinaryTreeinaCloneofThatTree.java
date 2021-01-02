package com.leetcode.javapractice;

public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

    public static final TreeNode getTargetCopy(
            final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null) {
            return res;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }

    public static void main(String[] args) {

        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);
        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);
        TreeNode target = original.right;
        System.out.println(getTargetCopy(original, cloned, target).val);
    }
}
