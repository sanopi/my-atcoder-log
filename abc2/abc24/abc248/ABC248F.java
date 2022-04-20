import java.io.PrintWriter;
import java.util.Scanner;

public class ABC248F {

    public static void main(String[] args) {
        int n = nextInt();
        int p = nextInt();

        long[][][] dp = new long[n][n+10][2];
        dp[0][0][0] = 1;
        dp[0][1][1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j][0] += dp[i-1][j][0];
                dp[i][j][0]%=p;

                dp[i][j+1][0] += 3*dp[i-1][j][0];
                dp[i][j+1][0]%=p;

                dp[i][j+2][1] += 2*dp[i-1][j][0];
                dp[i][j+2][1]%=p;


                dp[i][j][0] += dp[i-1][j][1];
                dp[i][j][0]%=p;

                dp[i][j+1][1] += dp[i-1][j][1];
                dp[i][j+1][1]%=p;
            }
        }

        for (int i = 1; i <= n-1; i++) {
            out.print(dp[n-1][i][0] + " ");
        }
        out.println();
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