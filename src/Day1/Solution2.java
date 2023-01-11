package Day1;

import java.util.Arrays;
import java.util.Scanner;

/*
Day 1: Quartiles
*/

public class Solution2 {

    public static void main(String[] args) {
        // Inputs
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();

        //Sort array
        Arrays.sort(array);

        int Q1 = findMedian(array, 0, size / 2 - 1);
        int Q2 = findMedian(array, 0, size - 1);
        int Q3 = size % 2 == 0 ? findMedian(array, size / 2, size - 1) : findMedian(array, size / 2 + 1, size - 1);

        System.out.println(Q1);
        System.out.println(Q2);
        System.out.println(Q3);
    }

    private static int findMedian(int[] x, int start, int end) {
        int length = end - start + 1;
        int median;
        if (length % 2 == 0) {
            median = (x[start + length / 2 - 1] + x[start + length / 2]) / 2;
        } else {
            median = x[start + length / 2];
        }
        return median;
    }


}

