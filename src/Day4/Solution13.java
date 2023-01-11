package Day4;


/*
Day 4: Geometric Distribution I
*/

import java.util.Scanner;

public class Solution13 {
    public static void main(String[] args) {
        // Inputs
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int denom = scan.nextInt();
        int n = scan.nextInt();
        scan.close();

        // Geometric Distribution
        double p = (double) num / denom;
        System.out.format("%.3f", geometric(n, p));
    }
    private static double geometric(int n, double p) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive integer");
        }
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("p must be a probability (between 0 and 1)");
        }
        return Math.pow(1 - p, n - 1) * p;
    }
}

