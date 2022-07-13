import java.io.PrintWriter;
import java.util.Scanner;

public class ABC185E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();

        int[] a = nextIntArray(n);
        int[] b = nextIntArray(m);
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(
                    dp[i-1][j-1] + (a[i-1] == b[j-1] ? 0 : 1),
                    Math.min(
                        dp[i-1][j] + 1,
                        dp[i][j-1] + 1
                    )
                );
            }
        }

        out.println(dp[n][m]);
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