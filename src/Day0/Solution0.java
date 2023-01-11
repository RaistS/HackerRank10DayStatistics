package Day0;

import java.util.Arrays;
import java.util.Scanner;

/*
Day 0: Mean, Median, and Mode
*/

public class Solution0 {
    public static void main(String[] args) {
        // Inputs
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numSerie = new int[N];
        for (int i = 0; i < N; i++) {
            numSerie[i] = sc.nextInt();
        }
        sc.close();

        // Calculate Mean, Median and Mode
        Arrays.sort(numSerie);
        System.out.println(mean(numSerie));
        System.out.println(median(numSerie));
        System.out.println(mode(numSerie));
    }

    //Mean
    public static double mean(int[] m) {
        int L = m.length;
        double sum = 0;
        double mean = 0;
        for (int i = 0; i < L; i++) {
            sum += m[i];
        }
        mean = sum / L;
        return mean;
    }

    // Median
    public static double median(int[] md) {
        int Lmd = md.length;
        double median = 0;
        if (Lmd % 2 == 0) {
            median = (md[Lmd / 2 - 1] + md[Lmd / 2]) / 2.0;
        } else {
            median = md[Lmd / 2];
        }
        return median;
    }

    // Mode
    public static int mode(int[] mod) {
        int maxValue = 0;
        int maxCount = 0;
        for (int i = 0; i < mod.length; ++i) {
            int count = 0;
            for (int j = 0; j < mod.length; ++j) {
                if (mod[j] == mod[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = mod[i];
            }
        }
        return maxValue;
    }
}