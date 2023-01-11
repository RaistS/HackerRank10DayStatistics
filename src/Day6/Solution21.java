package Day6;

import java.util.Scanner;

public class Solution21 {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double mean = sc.nextDouble();
        double std = sc.nextDouble();
        double P = sc.nextDouble();
        double zScore = sc.nextDouble();

        //Objective
        double A = 0;
        double B = 0;

        // Formula used
        double marginOfError = zScore * std / Math.sqrt(n);

        // Result
        A =  mean - marginOfError;
        B = mean - marginOfError;

        // Print
        System.out.format("%.2f%n", A);
        System.out.format("%.2f%n", B);

    }
}
