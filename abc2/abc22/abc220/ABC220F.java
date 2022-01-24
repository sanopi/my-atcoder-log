import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ABC220F {

    private static int n;
    private static ArrayList<Integer>[] g;
    private static int[] subCount;
    private static long[] ans;

    public static void main(String[] args) {
        n = nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        subCount = new int[n];
        Arrays.fill(subCount, 1);
        ans = new long[n];

        dfs(0, -1, 0);

        dfs2(0, -1);

        for (final long res : ans) {
            out.println(res);
        }
        out.flush();
    }

    private static void dfs(int node, int previous, int count) {
        ans[0] += count;
        for (final Integer next : g[node]) {
            if (previous != next) {
                dfs(next, node, count + 1);
                subCount[node] += subCount[next];
            }
        }
    }

    private static void dfs2(int node, int previous) {
        for (final Integer next : g[node]) {
            if (next != previous) {
                ans[next] += ans[node] - 2 * subCount[next] + n;
                dfs2(next, node);
            }
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