import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class E_Knapsack2 {

    public static void main(String[] args) {
        int n = nextInt();
        int wMax = nextInt();
        int[] ww = new int[n];
        int[] vv = new int[n];
        int vMax = 0;
        for (int i = 0; i < n; i++) {
            ww[i] = nextInt();
            int v = nextInt();
            vv[i] = v;
            vMax = Math.max(vMax, v);
        }

        int vSumMax = vMax * n;
        int[][] dp = new int[n][vSumMax+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], wMax+1);
        }
        dp[0][0] = 0;
        dp[0][vv[0]] = ww[0];
        int ans = vv[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < vSumMax+1; j++) {
                dp[i][j] = dp[i-1][j];
            }
            int v = vv[i];
            int w = ww[i];
            for (int j = 0; j + v < vSumMax+1; j++) {
                dp[i][j+v] = Math.min(dp[i][j+v], dp[i-1][j] + w);
                if (dp[i][j+v] <= wMax) {
                    ans = Math.max(ans, j+v);
                }
            }
        }
        out.println(ans);
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