package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterNodeInLinkedList {

    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        temp = head.next;
        stack.push(head);
        while (temp != null) {
            while (!stack.isEmpty() && stack.peek().val < temp.val) {
                map.put(stack.pop(), temp.val);
            }
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++, temp = temp.next) {
            result[i] = map.getOrDefault(temp, 0);
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);
        int[] result = nextLargerNodes(head);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}
