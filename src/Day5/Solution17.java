package Day5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Day 5: Normal Distribution I
 */

public class Solution17 {


    public static void main(String[] args) throws IOException {

        //Inputs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        double mean = Double.parseDouble(line1[0]);
        double sdev = Double.parseDouble(line1[1]);

        double lh = Double.parseDouble(br.readLine());

        String[] line3 = br.readLine().split(" ");
        double h1 = Double.parseDouble(line3[0]);
        double h2 = Double.parseDouble(line3[1]);

        //Print
        System.out.printf("%.3f\n", cumulative(mean, sdev, lh));
        System.out.printf("%.3f\n", cumulative(mean, sdev, h2) - cumulative(mean, sdev, h1));
    }

    // Cumulative probability
    public static double cumulative(double mean, double std, double x) {
        double parameter = (x - mean) / (std * Math.sqrt(2));
        return (0.5) * (1 + erf(parameter));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 +
                t * (1.00002368 +
                        t * (0.37409196 +
                                t * (0.09678418 +
                                        t * (-0.18628806 +
                                                t * (0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * (1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * (0.17087277))))))))));
        if (z >= 0) return ans;
        else return -ans;
    }


}
