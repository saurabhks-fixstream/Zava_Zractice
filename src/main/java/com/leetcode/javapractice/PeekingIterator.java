package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

    private Integer next = null;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            next = this.iterator.next();
        }
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer result = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
