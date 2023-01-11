package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution24 {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int X1 = Integer.parseInt(line1[0]);
        int Y1 = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int X2 = Integer.parseInt(line2[0]);
        int Y2 = Integer.parseInt(line2[1]);

        String[] line3 = br.readLine().split(" ");
        int X3 = Integer.parseInt(line3[0]);
        int Y3 = Integer.parseInt(line3[1]);

        String[] line4 = br.readLine().split(" ");
        int X4 = Integer.parseInt(line4[0]);
        int Y4 = Integer.parseInt(line4[1]);

        String[] line5 = br.readLine().split(" ");
        int X5 = Integer.parseInt(line5[0]);
        int Y5 = Integer.parseInt(line5[1]);

        int [] x = {X1, X2, X3, X4, X5};
        int [] y = {Y1, Y2, Y3, Y4, Y5};
        int studentScore = 80;

        /* Get coefficients for Least Square Regression Line */
        double b = pearson(x, y) * (standardDeviation(y) / standardDeviation(x));
        double a = mean(y) - b * mean(x);

        /* Calculate and print predicted score */
        double result =  (a + b * studentScore);
        System.out.format("%.3f", result);

    }
    public static double pearson(int[] xs, int[] ys) {
        double xMean = mean(xs);
        double yMean = mean(ys);
        int n = xs.length;

        double cov = 0;
        double xStdDev = 0;
        double yStdDev = 0;

        for (int i = 0; i < n; i++) {
            cov += (xs[i] - xMean) * (ys[i] - yMean);
            xStdDev += Math.pow(xs[i] - xMean, 2);
            yStdDev += Math.pow(ys[i] - yMean, 2);
        }
        cov /= n;
        xStdDev = Math.sqrt(xStdDev / n);
        yStdDev = Math.sqrt(yStdDev / n);

        return cov / (xStdDev * yStdDev);
    }
    public static double mean(int[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }
    public static double standardDeviation(int[] y) {
        double mean = mean(y);
        double variance = 0;
        for (double value : y) {
            variance += Math.pow(value - mean, 2);
        }
        variance /= y.length;
        return Math.sqrt(variance);
    }
}
