import java.io.PrintWriter;
import java.util.Scanner;

public class Q50_StairJump_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int l = nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i < l) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = (dp[i-1] + dp[i-l]) % 1000000007;
            }
        }
        out.println(dp[n]);
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}