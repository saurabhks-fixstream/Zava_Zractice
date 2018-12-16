package com.leetcode.JavaPractice;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> ar = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ar.add("FizzBuzz");
            } else if (i % 5 == 0) {
                ar.add("Buzz");
            } else if (i % 3 == 0) {
                ar.add("Fizz");
            } else {
                ar.add(String.valueOf(i));
            }
        }
        return ar;
    }

    public static void main(String[] args) {

        System.out.println(fizzBuzz(15));

    }

}
