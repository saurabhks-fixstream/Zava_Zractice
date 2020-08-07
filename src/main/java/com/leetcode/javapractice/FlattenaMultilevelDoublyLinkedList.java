package com.leetcode.javapractice;

public class FlattenaMultilevelDoublyLinkedList {

    public static MultilevelDLLNode flatten(MultilevelDLLNode head) {
        MultilevelDLLNode pointer = head;
        while (pointer != null) {
            if (pointer.child != null) {
                MultilevelDLLNode right = pointer.next;
                pointer.next = flatten(pointer.child);
                pointer.next.prev = pointer;
                pointer.child = null;
                while (pointer.next != null) {
                    pointer = pointer.next;
                }
                if (right != null) {
                    pointer.next = right;
                    pointer.next.prev = pointer;
                }
            }
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) {

        MultilevelDLLNode head = new MultilevelDLLNode(1);
        head.next = new MultilevelDLLNode(2);
        head.next.prev = head;
        head.next.next = new MultilevelDLLNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new MultilevelDLLNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new MultilevelDLLNode(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new MultilevelDLLNode(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.child = new MultilevelDLLNode(7);
        head.next.next.child.next = new MultilevelDLLNode(8);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.child = new MultilevelDLLNode(11);
        head.next.next.child.next.child.next = new MultilevelDLLNode(12);
        head.next.next.child.next.child.next.prev = head.next.next.child.next.child;
        head.next.next.child.next.next = new MultilevelDLLNode(9);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = new MultilevelDLLNode(10);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;
        head = flatten(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
