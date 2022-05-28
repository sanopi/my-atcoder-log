import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC253E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        // 便宜上0~m-1で考える
        long[][] dp = new long[n][m];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            long[] sum = new long[m +1];
            for (int j = 1; j <= m; j++) {
                sum[j] = sum[j-1] + dp[i-1][j-1];
                sum[j] %= MOD;
            }
            for (int j = 0; j < m; j++) {
                // k == 0の時、二重計上しない
                dp[i][j] += sum[Math.max(0, j- k +1)] + sum[m] - sum[Math.min(m, j+ Math.max(k, 1))];
                dp[i][j] %= MOD;
//                for (int l = 0; l < m; l++) {
//                    if (Math.abs(j-l)<k) continue;
//                    dp[i][j] += dp[i-1][l];
//                    dp[i][j] %= MOD;
//                }
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans += dp[n-1][i];
            ans %= MOD;
        }
        out.println((ans+MOD)%MOD);
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