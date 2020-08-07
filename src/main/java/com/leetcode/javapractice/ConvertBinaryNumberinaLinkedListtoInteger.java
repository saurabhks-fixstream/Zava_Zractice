package com.leetcode.javapractice;

public class ConvertBinaryNumberinaLinkedListtoInteger {

    public static int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
    }
}
