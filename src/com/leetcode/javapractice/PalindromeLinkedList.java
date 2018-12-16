package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int a = list.get(start++);
            int b = list.get(end--);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(isPalindrome(head));

    }

}
