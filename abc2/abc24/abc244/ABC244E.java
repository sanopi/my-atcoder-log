import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC244E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int s = nextInt()-1;
        int t = nextInt()-1;
        int x = nextInt()-1;

        List<Integer>[] g = new List[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }

        // sから初めて、i個移動してjに行く経路の数（途中でxを通る回数で、0か1を分ける）
        int[][][] dp = new int[2][k+1][n];
        dp[0][0][s] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p <= 1; p++) {
                    for (Integer next : g[j]) {
                        if (next.equals(x)) {
                            dp[1 - p][i][next] += dp[p][i - 1][j];
                            dp[1 - p][i][next] %= MOD;
                        } else {
                            dp[p][i][next] += dp[p][i - 1][j];
                            dp[p][i][next] %= MOD;
                        }
                    }
                }
            }
        }

        out.println(dp[0][k][t]);
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