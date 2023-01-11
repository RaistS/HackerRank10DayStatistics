package Day0;

import java.util.Arrays;
import java.util.Scanner;

/*
Day 0: Weighted Mean
*/

public class Solution1 {

    public static void main(String[] args) {
        // Inputs
        /* Save input */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arrayE = new int[size];
        int[] arrayW = new int[size];

        for (int i = 0; i < size; i++) {
            arrayE[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            arrayW[i] = sc.nextInt();
        }
        sc.close();

        double WeightedMean = weightedMean(arrayE, arrayW);

        System.out.format("%.1f", WeightedMean);
    }

    // element and weights length suppose to be the same
    static double weightedMean(int[] elements, int[] weights){
        double sum = 0;
        int totalWeight = 0;

        // step 1: multiply each element by its corresponding weight
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i] * weights[i];
            totalWeight += weights[i];
        }
        // step 2: divide the sum by the total weight
        return sum / totalWeight;
    }
}
