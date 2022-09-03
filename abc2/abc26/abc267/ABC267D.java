import java.io.PrintWriter;
import java.util.Scanner;

public class ABC267D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long[] a = nextLongArray(n);
        Long[][] dp = new Long[n][m+1];
        dp[0][0] = 0L;
        dp[0][1] = a[0];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0L;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m+1; j++) {
                if (dp[i-1][j] != null && dp[i-1][j-1] != null) {
                    dp[i][j] = Math.max(
                        dp[i-1][j],
                        dp[i-1][j-1] + a[i]*j
                    );
                } else if (dp[i-1][j] == null && dp[i-1][j-1] != null) {
                    dp[i][j] = dp[i-1][j-1] + a[i]*j;
                } else if (dp[i-1][j] != null && dp[i-1][j-1] == null) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }



        out.println(dp[n-1][m]);
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