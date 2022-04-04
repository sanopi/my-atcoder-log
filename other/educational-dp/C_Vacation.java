import java.io.PrintWriter;
import java.util.Scanner;

public class C_Vacation {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = nextInt();
            c[i] = nextInt();
        }

        int[][] dp = new int[n][3];
        dp[0][0] = a[0];
        dp[0][1] = b[0];
        dp[0][2] = c[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + a[i], dp[i-1][2] + a[i]);
            dp[i][1] = Math.max(dp[i-1][0] + b[i], dp[i-1][2] + b[i]);
            dp[i][2] = Math.max(dp[i-1][0] + c[i], dp[i-1][1] + c[i]);
        }
        out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
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