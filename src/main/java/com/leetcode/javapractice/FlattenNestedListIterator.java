package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

class NestedIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> lists;

    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<ListIterator<NestedInteger>>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()) {
                    return lists.peek().previous() == x;
                }
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }
}

public class FlattenNestedListIterator {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        NestedIterator nestedIterator = new NestedIterator(new ArrayList<NestedInteger>());
        while (nestedIterator.hasNext()) {
            list.add(nestedIterator.next());
        }
        System.out.println(list);
    }
}
