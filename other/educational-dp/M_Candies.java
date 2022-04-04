import java.io.PrintWriter;
import java.util.Scanner;

public class M_Candies {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);

        long[][] dp = new long[n][k+1];
        for (int i = 0; i < n; i++) {
             dp[i][0] = 1;
        }
        for (int i = 0; i < k+1; i++) {
            dp[0][i] = Math.min(Math.max(0, a[0]-i+1), 1);
        }

        for (int i = 1; i < n; i++) {
            long[] sum = new long[k+2];
            for (int j = 0; j < k + 1; j++) {
                sum[j+1] = sum[j] + dp[i-1][j];
            }
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j] + sum[j] - sum[Math.max(0, j-a[i])];
                dp[i][j] %= MOD;
            }
        }

        out.println(dp[n-1][k]);
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