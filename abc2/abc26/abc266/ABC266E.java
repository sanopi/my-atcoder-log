import java.io.PrintWriter;
import java.util.Scanner;

public class ABC266E {

    public static void main(String[] args) {
        int n = nextInt();
        double[] dp = new double[n];
        dp[n-1] = (double)(1+2+3+4+5+6)/6;
        for (int i = n - 2; i >= 0; i--) {
            double prev = dp[i + 1];
            for (int j = 1; j <= 6; j++) {
                dp[i] += Math.max(j, prev);
            }
            dp[i] /= 6;
        }
        out.println(dp[0]);
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