package com.crackingthecodinginterview.javapractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

    private static void createLevelLinkedListHelper(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedListHelper(root.left, lists, level + 1);
        createLevelLinkedListHelper(root.right, lists, level + 1);
    }

    public static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        if (root == null) {
            return lists;
        }
        createLevelLinkedListHelper(root, lists, 0);
        return lists;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        List<LinkedList<TreeNode>> lists = createLevelLinkedList(root);
        for (LinkedList<TreeNode> list : lists) {
            for (TreeNode node : list) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }

    }

}
