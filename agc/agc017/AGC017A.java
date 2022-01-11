import java.io.PrintWriter;
import java.util.Scanner;

public class AGC017A {

    public static void main(String[] args) {
        int n = nextInt();
        int p = nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt()%2;
        }
        long[][] dp = new long[n][2];
        dp[0][0]+=1;
        dp[0][a[0]]+=1;
        for (int i = 1; i < n; i++) {
            if (a[i] == 0) {
                dp[i][0] = dp[i-1][0]*2;
                dp[i][1] = dp[i-1][1]*2;
            } else {
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = dp[i-1][0] + dp[i-1][1];
            }
        }

        out.println(dp[n-1][p]);
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