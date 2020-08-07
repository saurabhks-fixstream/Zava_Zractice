package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

class Logger {

    Map<String, Integer> map;

    public Logger() {
        map = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        int diff = timestamp - map.get(message);
        if (diff < 10) {
            return false;
        } else {
            map.put(message, timestamp);
        }
        return true;
    }
}

public class LoggerRateLimiter {

    public static void main(String[] args) {

        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}
