package Day4;

import java.util.Scanner;


/*
Day 4: Binomial Distribution I
*/

public class Solution11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Inputs
        double l = sc.nextDouble();
        double r = sc.nextDouble();
        sc.close();
        // odds
        double odds = l/r;

        double sum = 0;

        // Sum of b(i, 6, odds / (1 + odds)) for i in range(3, 7)
        for (int i = 3; i < 7; i++) {
            sum += comb(6, i) * Math.pow(odds / (1 + odds), i) * Math.pow(1 - (odds / (1 + odds)), 6 - i);
        }
        // Round the sum to 3 decimal positions and print it
        System.out.println(Math.round(sum * 1000.0) / 1000.0);

    }
    public static int comb(int n, int x) {
        if (x > n - x) {
            x = n - x;
        }
        int numerator = 1;
        for (int i = n; i > n - x; i--) {
            numerator *= i;
        }
        int denominator = 1;
        for (int i = 1; i <= x; i++) {
            denominator *= i;
        }
        return numerator / denominator;
    }
}
