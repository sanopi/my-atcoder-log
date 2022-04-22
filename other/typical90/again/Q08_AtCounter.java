package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q08_AtCounter {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        String atcoder = "atcoder";
        int len = atcoder.length();

        long[][] dp = new long[n][len+1];
        dp[0][1] = (s.charAt(0) == atcoder.charAt(0) ? 1:0);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            char si = s.charAt(i);
            for (int j = 1; j <= len; j++) {
                if (si == atcoder.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= MOD;
            }
        }
        out.println(dp[n-1][len]);
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