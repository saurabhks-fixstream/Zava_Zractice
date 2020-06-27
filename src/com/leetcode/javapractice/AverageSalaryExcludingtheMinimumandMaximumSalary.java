package com.leetcode.javapractice;

public class AverageSalaryExcludingtheMinimumandMaximumSalary {

    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        double average = (sum - min - max) / (salary.length - 2);
        return average;
    }

    public static void main(String[] args) {

        int[] salary = { 4000, 3000, 1000, 2000 };
        System.out.println(average(salary));

    }

}
