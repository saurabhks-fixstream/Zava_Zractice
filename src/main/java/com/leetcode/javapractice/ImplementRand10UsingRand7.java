package com.leetcode.javapractice;

import java.util.Random;

class ImplementRand10UsingRand7Base {

    static Random random = new Random();

    public static int rand7() {
        return random.nextInt(6) + 1;
    }
}

public class ImplementRand10UsingRand7 extends ImplementRand10UsingRand7Base {

    public static int rand10() {
        int rand40 = 40;
        while (rand40 >= 40) {
            rand40 = (rand7() - 1) * 7 + rand7() - 1;
        }
        return rand40 % 10 + 1;
    }

    public static void main(String[] args) {

        System.out.println(rand10());
    }
}
