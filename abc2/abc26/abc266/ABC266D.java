import java.io.PrintWriter;
import java.util.Scanner;

public class ABC266D {

    public static void main(String[] args) {
        int n = nextInt();
        Snk[] snks = new Snk[100001];
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            int x = nextInt();
            int a = nextInt();
            snks[t] = new Snk(t, x, a);
        }
        long[][] dp = new long[100001][5];
        {
            Snk snk = snks[100000];
            if (snk != null) {
                dp[100000][snk.x] = snk.a;
            }
        }

        for (int i = 100000-1; i >= 0; i--) {
            Snk snk = snks[i];
            for (int j = 0; j < 5; j++) {
                dp[i][j] = Math.max(
                    dp[i+1][Math.max(0, j-1)],
                    Math.max(
                        dp[i+1][j],
                        dp[i+1][Math.min(4, j+1)]
                    )
                );
                if (snk != null && snk.x == j) {
                    dp[i][j] += snk.a;
                }
            }
        }

        out.println(dp[0][0]);
        out.flush();
    }

    private static class Snk {
        int t;
        int x;
        int a;
        public Snk(int t, int x, int a) {
            this.t = t;
            this.x = x;
            this.a = a;
        }
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