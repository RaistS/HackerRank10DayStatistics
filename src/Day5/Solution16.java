package Day5;


/*
Day 5: Poisson Distribution II
 */


import java.util.Scanner;

public class Solution16 {
    public static void main(String[] args) {
        //Inputs
        Scanner sc = new Scanner(System.in);
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        sc.close();

        // Used formula: E[X^2] =  λ +  λ^2
        double dailyCostMachineA = 160 + 40 * (A + (A * A));
        double dailyCostMachineB = 128 + 40 * (B + (B * B));

        // Print
        System.out.format("%.3f%n", dailyCostMachineA);
        System.out.format("%.3f%n", dailyCostMachineB);
    }
}
