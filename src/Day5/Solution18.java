package Day5;


/*
Day 5: Normal Distribution II
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution18 {
    public static void main(String[] args) throws IOException {

        // Inputs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        double mean = Double.parseDouble(line1[0]);
        double sdev = Double.parseDouble(line1[1]);

        double lh1 = Double.parseDouble(br.readLine());
        double lh2 = Double.parseDouble(br.readLine());

        // Results
        double result_1 = 100 * (1 - cumulative(mean, sdev, lh1));
        double result_2 = 100 * (1 - cumulative(mean, sdev, lh2));
        double result_3 = 100 * (cumulative(mean, sdev, lh1));
        //Print
        System.out.format("%.2f%n", result_1);
        System.out.format("%.2f%n", result_2);
        System.out.format("%.2f%n", result_3);
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






