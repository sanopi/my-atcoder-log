import java.io.PrintWriter;
import java.util.Scanner;

public class ABC222D {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);

        int[][] dp = new int[n][3001];
        for (int i = a[0]; i < 3001; i++) {
            if (i <= b[0]) {
                dp[0][i] = 1 + (i != 0 ? dp[0][i - 1] : 0);
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        int prevMin = a[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3001; j++) {
                if (j < a[i]) continue;
                if (j < prevMin) continue;
                if (j <= b[i]) {
                    int f1 = dp[i - 1][j];
                    int f2 = (j - 1 < 0 ? 0 : dp[i][j - 1]);
                    dp[i][j] = (f1 + f2) % MOD;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
            prevMin = a[i];
        }

        out.println(dp[n - 1][3000]);
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