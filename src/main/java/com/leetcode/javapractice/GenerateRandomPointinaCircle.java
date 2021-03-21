package com.leetcode.javapractice;

public class GenerateRandomPointinaCircle {

    double radius;
    double x_center;
    double y_center;

    public GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        double x = x_center + len * Math.cos(deg);
        double y = y_center + len * Math.sin(deg);
        return new double[] {x, y};
    }

    public static void main(String[] args) {

        GenerateRandomPointinaCircle random = new GenerateRandomPointinaCircle(1.0, 0.0, 0.0);
        double[] point = random.randPoint();
        System.out.println("[" + point[0] + "," + point[1] + "]");
    }
}
