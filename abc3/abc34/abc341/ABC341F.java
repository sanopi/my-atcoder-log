import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC341F {

    private static long[] memo;
    private static int[] w;
    private static List<Integer>[] g;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }
        w = nextIntArray(n);
        long[] a = nextLongArray(n);
        memo = new long[n];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++) {
            if (memo[i] >= 0) continue;
            dfs(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i]*memo[i];
        }
        out.println(ans);
        out.flush();
    }

    private static long dfs(int current) {
        if (memo[current] >= 0) {
            return memo[current];
        }
        List<P> list = new ArrayList<>();
        for (Integer next : g[current]) {
            if (w[current] <= w[next]) continue;
            long result = dfs(next);
            list.add(new P(w[next], result));
        }
        if (list.isEmpty()) return memo[current] = 1;
//        System.out.println(current + " " + list);

        int n = list.size();
        int W_MAX = w[current];
        long[][] dp = new long[n+1][W_MAX];
        for (int i = 0; i < n; i++) {
            P pi = list.get(i);
            int wi = pi.w;
            long ci = pi.c;
            for (int j = 0; j < W_MAX; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                if (j+wi >= W_MAX) continue;
                dp[i+1][j+wi] = Math.max(dp[i+1][j+wi], dp[i][j]+ci);
            }
        }
        long res = 0;
        for (int i = 0; i < W_MAX; i++) {
            res = Math.max(res, dp[n][i]);
        }
        return memo[current] = res+1;
    }

    private static class P {
        int w;
        long c;
        public P(int w, long c) {
            this.w = w;
            this.c = c;
        }
        @Override
        public String toString() {
            return "P{" +
                "w=" + w +
                ", c=" + c +
                '}';
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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