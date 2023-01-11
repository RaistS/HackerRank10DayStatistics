package Day7;

import java.util.Scanner;

public class Solution22 {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        double [] xset = new double[size];
        double [] yset = new double[size];
        for (int i = 0; i < size; i++) {
            xset[i] = sc.nextDouble();
        }
        for (int i = 0; i < size; i++) {
            yset[i] = sc.nextDouble();
        }
        sc.close();

        System.out.println(pearson(xset, yset));

    }
    public static double pearson(double[] xs, double[] ys) {
        double xMean = mean(xs);
        double yMean = mean(ys);
        int n = xs.length;

        double numerator = 0;
        double denominator1 = 0;
        double denominator2 = 0;

        for (int i = 0; i < n; i++) {
            numerator += (xs[i] - xMean) * (ys[i] - yMean);
            denominator1 += Math.pow(xs[i] - xMean, 2);
            denominator2 += Math.pow(ys[i] - yMean, 2);
        }
        return numerator / Math.sqrt(denominator1 * denominator2);
    }

    public static double mean(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

}
