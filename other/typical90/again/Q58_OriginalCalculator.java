package again;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q58_OriginalCalculator {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();

        int[] appears = new int[100000];
        Arrays.fill(appears, -1);
        int count = 0;
        while (appears[n]<0 && k-->0) {
            appears[n] = count++;
            n = calc(n);
        }
        k = k%(count-appears[n]);
        while (k-->0) {
            n = calc(n);
        }
        out.println(n);
        out.flush();
    }

    private static int calc(int n) {
        int res = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            res += c-'0';
        }
        return (n+res)%100000;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
    static double nextDouble() { return Double.parseDouble(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}