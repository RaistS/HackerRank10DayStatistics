package Day1;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'interQuartile' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER_ARRAY freqs
     */

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            int val = values.get(i);
            int freq = freqs.get(i);
            for (int j = 0; j < freq; j++) {
                data.add(val);
            }
        }

        int n = data.size();
        data.sort(Integer::compareTo);

        double Q1 = findMedian(data, 0, n / 2 - 1);
        double Q3 = findMedian(data, n % 2 == 0 ? n / 2 : n / 2 + 1, n - 1);

        double interquartile = Q3 - Q1;
        System.out.println(interquartile);
    }

    private static double findMedian(List<Integer> data, int start, int end) {
        int length = end - start + 1;
        if (length % 2 == 0) {
            return (data.get(start + length / 2 - 1) + data.get(start + length / 2)) / 2.0;
        } else {
            return data.get(start + length / 2);
        }
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] valTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> val = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int valItem = Integer.parseInt(valTemp[i]);
            val.add(valItem);
        }

        String[] freqTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> freq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int freqItem = Integer.parseInt(freqTemp[i]);
            freq.add(freqItem);
        }

        Result.interQuartile(val, freq);

        bufferedReader.close();
    }
}
