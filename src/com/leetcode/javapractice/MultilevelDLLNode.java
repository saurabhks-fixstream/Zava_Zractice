package com.leetcode.javapractice;

public class MultilevelDLLNode {

    int val;
    MultilevelDLLNode prev;
    MultilevelDLLNode next;
    MultilevelDLLNode child;

    MultilevelDLLNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }

}
