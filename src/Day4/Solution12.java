package Day4;


/*
Day 4: Binomial Distribution II
*/

public class Solution12 {
    public static void main(String[] args) {


        //values given
        double p = 0.12;
        double q = 1 - p;
        int n = 10;


        //The probability that a batch of 10 pistons will contain no more than 2 rejects.
        double p0 = 0; double p1 =0; double p2 = 0;
        double probabilityNoMoreThan2Rejects = p0 + p1 + p2;
        //The probability that a batch of 10 pistons will contain at least 2 rejects.
        double probabilityAtLeast2Rejects = 1 - (p0 + p1);

        //0 rejects in the batch
        p0 = Math.pow(q, n) * factorial(n) / (factorial(0) * factorial(n - 0));
        //1 rejects in the batch
        p1 = (p * Math.pow(q, n - 1)) * factorial(n) / (factorial(1) * factorial(n - 1));
        //2 rejects in the batch
        p2 = (Math.pow(p, 2) * Math.pow(q, n - 2)) * factorial(n) / (factorial(2) * factorial(n - 2));


        System.out.format("%.3f%n", probabilityNoMoreThan2Rejects);
        System.out.format("%.3f%n", probabilityAtLeast2Rejects);
    }
    public static double factorial(int x) {
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
