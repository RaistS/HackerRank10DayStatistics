package Day5;

/*
Day 5: Poisson Distribution I
 */


import java.util.Scanner;

public class Solution15 {
    public static void main(String[] args) {
        //Inputs
        Scanner sc = new Scanner(System.in);
        double lambda = sc.nextDouble();
        int k = sc.nextInt();
        sc.close();

        double P = poisson(k, lambda);
        System.out.println("The Poisson Probability is " + P);
    }
    private static double poisson(int k, double lambda) {
        if (k < 0) {
            throw new IllegalArgumentException("k must be non-negative");
        }

        if (lambda <= 0) {
            throw new IllegalArgumentException("lambda must be a positive value");
        }

        return (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k);
    }
    private static double factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x cannot be negative");
        }
        double fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
}
