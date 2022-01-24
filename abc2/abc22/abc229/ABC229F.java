import java.io.PrintWriter;
import java.util.Scanner;

public class ABC229F {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        long[][] dp = new long[n][3];
        // bi, ai, (ai+1)
        dp[0][0] = b[0];
        dp[0][1] = a[0];
        dp[0][2] = a[1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][0]+b[i], Math.min(dp[i-1][1]+b[i], dp[i-1][2]+b[i]));
            dp[i][1] = Math.min(dp[i-1][0]+a[i], Math.min(dp[i-1][1]+a[i], dp[i-1][2]));
            dp[i][2] = Math.min(dp[i-1][0]+a[(i+1)%n], Math.min(dp[i-1][1]+a[(i+1)%n], dp[i-1][2]+a[(i+1)%n]));
        }
        out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
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