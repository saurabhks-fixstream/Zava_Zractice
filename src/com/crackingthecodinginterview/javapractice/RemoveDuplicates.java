package com.crackingthecodinginterview.javapractice;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (!set.contains(curr.val)) {
                set.add(curr.val);
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(7);
        deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();

    }

}
