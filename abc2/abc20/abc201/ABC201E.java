import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC201E {

    private static final int MOD = 1000000007;

    private static List<Edge>[] tree;
    private static int n;

    private static long[] xor;

    public static void main(String[] args) {
        n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            long w = nextLong();
            tree[u].add(new Edge(v, w, i));
            tree[v].add(new Edge(u, w, i));
        }
        xor = new long[n];
        dfs(0, -1, 0);
        long[] one = new long[60];
        long[] zero = new long[60];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 60; j++) {
                if ((xor[i] & 1L<<j) == 0) {
                    zero[j]++;
                } else {
                    one[j]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 60; i++) {
            ans += (1L<<i)%MOD*(zero[i]*one[i]%MOD);
            ans %= MOD;
        }
        out.println(ans);
        out.flush();
    }

    private static void dfs(int current, int prev, long currentXor) {
        xor[current] = currentXor;
        for (Edge edge : tree[current]) {
            if (edge.to == prev) continue;
            dfs(edge.to, current, currentXor ^ edge.w);
        }
    }

    private static class Edge {
        int to;
        long w;
        int i;
        public Edge(int to, long w, int i) {
            this.to = to;
            this.w = w;
            this.i = i;
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