package com.leetcode.JavaPractice;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (list.contains(temp)) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        ListNode node1 = new ListNode(2);
        headA.next = node1;
        ListNode headB = new ListNode(3);
        ListNode node2 = new ListNode(4);
        headB.next = node2;
        ListNode node3 = new ListNode(5);
        node1.next = node3;
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        node3.next = node4;
        ListNode head = getIntersectionNode(headA, headB);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();

    }

}
