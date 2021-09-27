import java.io.PrintWriter;
import java.util.Scanner;

public class ABC220D {

    private static int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int[][] dp = new int[n][10];
        dp[0][a[0]] = 1;

        for (int i = 0; i < n - 1; i++) {
            int nextI = i + 1;
            int ai1 = a[nextI];
            for (int j = 0; j < 10; j++) {
                int f = (j + ai1) % 10;
                dp[nextI][f] = (dp[nextI][f] + dp[i][j]) % MOD;
                int g = (j * ai1) % 10;
                dp[nextI][g] = (dp[nextI][g] + dp[i][j]) % MOD;
            }
        }

        for (final int i : dp[n - 1]) {
            out.println(i);
        }
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}