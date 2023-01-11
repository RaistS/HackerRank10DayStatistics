package Day1;

import java.util.Scanner;


/*
Day 1: Standard Deviation
*/


public class Solution4 {

    public static void main(String[] args) {

        // Inputs
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();

        System.out.format("%.1f", standardDeviation(array));
    }

    public static double getMean(int[] array) {
        int sum = 0;
        int numElements = array.length;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / numElements;
    }

    public static double standardDeviation(int[] array) {
        double mean = getMean(array);
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i] - mean, 2);
        }
        double variance = sum / array.length;
        return Math.sqrt(variance);
    }
}



