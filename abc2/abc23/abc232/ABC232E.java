import java.io.PrintWriter;
import java.util.Scanner;

public class ABC232E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        long h = nextInt();
        long w = nextInt();
        int k = nextInt();
        long x1 = nextInt();
        long y1 = nextInt();
        long x2 = nextInt();
        long y2 = nextInt();

        // 0 = x2, y2 にいる
        // 1 = x2, not y2 にいる
        // 2 = not x2, y2 にいる
        // 3 = それ以外にいる
        long[][] dp = new long[4][k+1];
        if (x1 == x2 && y1 == y2) dp[0][0] = 1;
        if (x1 == x2 && y1 != y2) dp[1][0] = 1;
        if (x1 != x2 && y1 == y2) dp[2][0] = 1;
        if (x1 != x2 && y1 != y2) dp[3][0] = 1;

        for (int i = 1; i <= k; i++) {
            dp[0][i] = dp[1][i-1] + dp[2][i-1];
            dp[0][i] %= MOD;
            dp[1][i] = dp[0][i-1]*(w-1)%MOD + dp[1][i-1]*(w-2)%MOD + dp[3][i-1];
            dp[1][i] %= MOD;
            dp[2][i] = dp[0][i-1]*(h-1)%MOD + dp[2][i-1]*(h-2)%MOD + dp[3][i-1];
            dp[2][i] %= MOD;
            dp[3][i] = dp[1][i-1]*(h-1)%MOD + dp[2][i-1]*(w-1)%MOD + dp[3][i-1]*(h-2 + w-2)%MOD;
            dp[3][i] %= MOD;
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