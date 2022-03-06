import java.io.PrintWriter;
import java.util.Scanner;

public class ABC242C {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        long[][] dp = new long[10][n+1];
        for (int i = 1; i < 10; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                dp[j][i] = (j>1?dp[j-1][i-1]:0) + dp[j][i-1] + (j<9?dp[j+1][i-1]:0);
                dp[j][i] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += dp[i][n];
        }
        out.println(ans%MOD);
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