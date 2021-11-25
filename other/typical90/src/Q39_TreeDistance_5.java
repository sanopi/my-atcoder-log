import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Q39_TreeDistance_5 {

    private static ArrayList<Integer>[] g;

    private static int n;
    private static int[] dp;
    private static long ans = 0;

    public static void main(String[] args) {
        n = nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }

        dp = new int[n];
        dfs(0, -1);

        out.println(ans);
        out.flush();
    }

    private static void dfs(int node, int previous) {
        dp[node] = 1;
        for (final Integer next : g[node]) {
            if (next != previous) {
                dfs(next, node);
                dp[node] += dp[next];
            }
        }
        ans += ((long) dp[node] * (n - dp[node]));
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