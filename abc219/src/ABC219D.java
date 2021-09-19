import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC219D {

    static int INF = 1000000000;

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();

        // i個目までのお弁当で、x,yを達成できる最小数
        int[][][] dp = new int[n+1][x+1][y+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                dp[0][i][j] = INF;
            }
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();

            for (int j = 0; j <= x; j++) {
                for (int k = 0; k <= y; k++) {
                    int tako = Math.min(j + a, x);
                    int tai = Math.min(k + b, y);
                    dp[i+1][tako][tai] = Math.min(dp[i+1][tako][tai], dp[i][j][k]+1);
                    dp[i+1][j][k] = Math.min(dp[i+1][j][k], dp[i][j][k]);
                }
            }
        }

        int ans = dp[n][x][y];
        if (ans == INF) {
            out.println(-1);
        } else {
            out.println(ans);
        }
        out.flush();
    }

    private static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
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