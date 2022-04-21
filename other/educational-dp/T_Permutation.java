import java.io.PrintWriter;
import java.util.Scanner;

public class T_Permutation {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

        // i番目までの数を決めて、i番目の数より大きいものがj個残っている 場合の数
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            long[] sum = new long[n+1];
            for (int j = 0; j < n; j++) {
                sum[j+1] = sum[j] + dp[i-1][j];
            }
            if (s.charAt(i-1) == '<') {
                for (int j = 0; j <= n-i-1; j++) {
                    dp[i][j] += sum[n-i+1] - sum[j+1];
                    dp[i][j] %= MOD;
                }
            } else {
                for (int j = 0; j <= n-i-1; j++) {
                    dp[i][j] += sum[j+1];
                    dp[i][j] %= MOD;
                }
            }
        }
        out.println(dp[n-1][0]);
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