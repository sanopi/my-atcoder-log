import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class Q56_LuckyBag_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int s = nextInt();

        String[][] dp = new String[n+1][s+1];
        for (int i = 0; i <= n; i++) {
            fill(dp[i], "X");
        }
        dp[0][0] = "";
        for (int i = 1; i <= n; i++) {
            int a = nextInt();
            int b = nextInt();
            for (int j = s - min(a, b); j >= 0 ; j--) {
                if (dp[i-1][j].length() != i-1) {
                    continue;
                }
                if (dp[i-1][j].equals("X")) {
                    continue;
                }
                if (j+a <= s) {
                    dp[i][j+a] = dp[i-1][j] + "A";
                }
                if (j+b <= s) {
                    dp[i][j+b] = dp[i-1][j] + "B";
                }
            }
        }

        out.println(dp[n][s].equals("X") ? "Impossible" : dp[n][s]);
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