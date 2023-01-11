package Day4;

import java.util.Scanner;

/*
Day 4: Geometric Distribution II
*/

public class Solution14 {
    public static void main(String[] args) {
        // Inputs
        Scanner sc = new Scanner(System.in);
        int num   = sc.nextInt();
        int denom = sc.nextInt();
        sc.close();

        // Geometric distribution
        double p = (double) num / denom;
        double result = 0;
        for (int i = 1; i <= 5; i++) {
            result += geometric(i, p);
        }
        System.out.format("%.3f", result);
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
