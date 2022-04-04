import java.io.PrintWriter;
import java.util.Scanner;

public class I_Coins {

    public static void main(String[] args) {
        int n = nextInt();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = nextDouble();
        }
        double[][] dp = new double[n][n+1];
        dp[0][0] = (1-p[0]);
        dp[0][1] = (p[0]);

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <= i+1; j++) {
                dp[i+1][j] += dp[i][j]*(1-p[i+1]);
                dp[i+1][j+1] += dp[i][j]*(p[i+1]);
            }
        }
        double ans = 0;
        for (int i = n/2+1; i <= n; i++) {
            ans+=dp[n-1][i];
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