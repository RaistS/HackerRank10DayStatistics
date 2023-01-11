package Day7;

import java.util.*;

public class Solution23 {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] X = new double[N];
        double[] Y = new double[N];
        for (int i = 0; i < N; i++) {
            X[i] = sc.nextDouble();
        }
        for (int i = 0; i < N; i++) {
            Y[i] = sc.nextDouble();
        }
        sc.close();

        System.out.format("%.3f", spearman(X, Y));
    }

    public static double spearman(double[] xs, double[] ys) {
        int n = xs.length;
        double[] xRanks = new double[n];
        double[] yRanks = new double[n];

        // assign ranks to each variable
        xRanks = rank(xs);
        yRanks = rank(ys);

        double numerator = 0;
        for (int i = 0; i < n; i++) {
            numerator += Math.pow(xRanks[i] - yRanks[i], 2);
        }
        numerator *= 6;
        double denominator = n * (n * n - 1);

        return 1 - (numerator / denominator);
    }

    private static double[] rank(double[] array) {
        double[] sorted = array.clone();
        Arrays.sort(sorted);

        Map<Double, Double> rank = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            rank.putIfAbsent(sorted[i], 0d);
            rank.put(sorted[i], rank.get(sorted[i]) + i);
        }

        for (int i = 0; i < array.length; i++) {
            sorted[i] = rank.get(array[i]) + 1;
        }
        return sorted;
    }

    /* A class to store 2 variables */
    class Pair {
        public final int index;
        public final double value;

        public Pair(int i, double v) {
            index = i;
            value = v;
        }
    }

    /* This lets us sort Pairs based on their value field */
    class PairValueComparator implements Comparator<Pair> {
        double epsilon = 0.0001; // shouldn't use " == " to compare "doubles"

        @Override
        public int compare(Pair p1, Pair p2) {
            if (Math.abs(p1.value - p2.value) < epsilon) {
                return 0;
            } else if (p1.value < p2.value) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
