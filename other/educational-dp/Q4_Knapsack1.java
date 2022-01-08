import java.io.PrintWriter;
import java.util.Scanner;

public class Q4_Knapsack1 {

    public static void main(String[] args) {
        int n = nextInt();
        int wMax = nextInt();
        int[] ww = new int[n];
        long[] vv = new long[n];
        for (int i = 0; i < n; i++) {
            ww[i] = nextInt();
            vv[i] = nextLong();
        }

        long[][] dp = new long[n][wMax+1];
        for (int i = ww[0]; i <= wMax; i++) {
            dp[0][i] = vv[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= wMax; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
            int w = ww[i];
            for (int j = 0; j + w <= wMax; j++) {
                dp[i][j+w] = Math.max(dp[i][j+w], dp[i-1][j] + vv[i]);
            }
        }
        out.println(dp[n-1][wMax]);
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