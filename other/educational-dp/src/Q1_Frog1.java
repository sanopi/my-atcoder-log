import java.io.PrintWriter;
import java.util.Scanner;

public class Q1_Frog1 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] h = nextIntArray(n);

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(h[1] - h[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(
                dp[i-2] + Math.abs(h[i] - h[i-2]),
                dp[i-1] + Math.abs(h[i] - h[i-1])
            );
        }
        out.println(dp[n-1]);
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