package Day6;


/*
Day 6: The Central Limit Theorem I
 */


import java.util.Scanner;

public class Solution19 {
    public static void main(String[] args) {

        //Inputs
        Scanner sc = new Scanner(System.in);
        double maxWeight = sc.nextDouble();
        int n = sc.nextInt();
        double mean = sc.nextDouble();
        double std = sc.nextDouble();

        double inputMean = n * mean;
        double inputSTD = Math.sqrt(n) * std;
        //Result
        double CL = cumulative(inputMean, inputSTD, maxWeight);

        System.out.format("%.4f", CL);
    }

    public static double cumulative(double mean, double sdev, double x) {
        double parameter = (x - mean) / (sdev * Math.sqrt(2));
        return (0.5) * (1 + erf(parameter));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                t * ( 1.00002368 +
                        t * ( 0.37409196 +
                                t * ( 0.09678418 +
                                        t * (-0.18628806 +
                                                t * ( 0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * ( 1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
    }

}
