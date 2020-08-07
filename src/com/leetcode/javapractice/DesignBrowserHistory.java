package com.leetcode.javapractice;

import java.util.LinkedList;

public class DesignBrowserHistory {

    LinkedList<String> websites;
    int currentIdx;

    public DesignBrowserHistory(String homepage) {
        websites = new LinkedList<String>();
        websites.addLast(homepage);
        currentIdx = 0;
    }

    public void visit(String url) {
        websites.subList(currentIdx + 1, websites.size()).clear();
        websites.addLast(url);
        currentIdx++;
    }

    public String back(int steps) {
        currentIdx = currentIdx - steps < 0 ? 0
                : currentIdx - steps;
        return websites.get(currentIdx);
    }

    public String forward(int steps) {
        currentIdx = currentIdx + steps >= websites.size() - 1 ? websites.size() - 1
                : currentIdx + steps;
        return websites.get(currentIdx);
    }

    public static void main(String[] args) {

        DesignBrowserHistory browserHistory = new DesignBrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

    }

}
