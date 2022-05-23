import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC212E {
    private static final int MOD = 998244353;
    private static int n;
    private static List<Integer>[] g;

    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();
        int k = nextInt();

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }

        long[][] dp = new long[k+1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k ; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += dp[i-1][j];
                sum %= MOD;
            }

            for (int j = 0; j < n; j++) {
                long minusSum = dp[i-1][j];
                for (Integer prev : g[j]) {
                    minusSum += dp[i-1][prev];
                    minusSum %= MOD;
                }
                dp[i][j] = (sum-minusSum+MOD)%MOD;
            }
        }
        out.println(dp[k][0]);
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