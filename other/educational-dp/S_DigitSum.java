import java.io.PrintWriter;
import java.util.Scanner;

public class S_DigitSum {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        String k = next();
        int d = nextInt();
        int n = k.length();
        long[][][] dp = new long[n][d][2];

        int k0 = k.charAt(0) - '0';
        for (int i = 0; i < k0; i++) {
            dp[0][i%d][0] += 1;
        }
        dp[0][k0%d][1] += 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < d; l++) {
                    int next = (l + j) % d;
                    dp[i][next][0] += dp[i-1][l][0];
                    dp[i][next][0]%=MOD;
                }
            }
            int ki = k.charAt(i) - '0';
            for (int j = 0; j < ki; j++) {
                for (int l = 0; l < d; l++) {
                    int next = (l + j) % d;
                    dp[i][next][0] += dp[i-1][l][1];
                    dp[i][next][0]%=MOD;
                }
            }
            for (int l = 0; l < d; l++) {
                int next = (l + ki) % d;
                dp[i][next][1] += dp[i-1][l][1];
                dp[i][next][1]%=MOD;
            }
        }
        out.println((dp[n-1][0][0]-1 + dp[n-1][0][1]+MOD)%MOD);
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