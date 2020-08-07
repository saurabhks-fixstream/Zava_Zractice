package com.leetcode.javapractice;

public class RemoveLinkedListElements {

    private static ListNode removeElementsHelper(ListNode head, int position) {
        if (position == 1) {
            head = head.next;
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (position > 1) {
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = temp.next;
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        int position = 1;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                head = removeElementsHelper(head, position);
            } else {
                position++;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head = removeElements(head, 2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
