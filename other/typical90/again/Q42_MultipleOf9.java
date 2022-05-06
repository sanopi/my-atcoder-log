package again;

import java.io.*;
import java.util.*;

public class Q42_MultipleOf9 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int k = nextInt();
        long[][] dp = new long[9][k+1];
        for (int i = 1; i <= Math.min(k, 9); i++) {
            dp[i%9][i] = 1;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 9; j++) {
                for (int l = 1; l <= 9; l++) {
                    int nextK = i + l;
                    if (nextK > k) continue;
                    int rest = (10 * j + l) % 9;
                    dp[rest][nextK] += dp[j][i];
                    dp[rest][nextK] %= MOD;
                }
            }
        }
        out.println(dp[0][k]);
        out.flush();
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