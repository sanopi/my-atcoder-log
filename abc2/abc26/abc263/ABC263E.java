import java.io.PrintWriter;
import java.util.Scanner;

public class ABC263E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n-1);
        long[] dp = new long[n];
        long[] sum = new long[n+1];

        for (int i = n - 2; i >= 0; i--) {
            int ai = a[i];
            long addSum = sum[i+1] - sum[i + ai + 1] + ai+1;
            addSum = (addSum+MOD)%MOD;
            long R = (modPow(ai, MOD - 2, MOD) * addSum) % MOD;

            dp[i] = R;
            sum[i] = (sum[i+1] + R)%MOD;
        }
        out.println(dp[0]);
        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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