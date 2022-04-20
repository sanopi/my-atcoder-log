import java.io.PrintWriter;
import java.util.Scanner;

public class ABC248C {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        long[][] dp = new long[n][k+1];
        for (int i = 1; i <= Math.min(m, k); i++) {
            dp[0][i] = 1;
        }
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = Math.max(1, j-m); l < j; l++) {
                    dp[i][j] += dp[i-1][l];
                    dp[i][j] %= MOD;
                }
            }
        }
        long ans = 0;
        for (long l : dp[n-1]) {
            ans += l;
            ans %= MOD;
        }
        out.println(ans);
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