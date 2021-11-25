import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC226E {

    private static int n;
    private static int m;
    private static ArrayList<Integer>[] g;
    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }

        int count = 0;
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (done[i]) {
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            dfs(i, -1, set);
            if (set.stream().mapToInt(j -> g[j].size()).sum() / 2 != set.size()) {
                System.out.println(0);
                return;
            }
            set.forEach(j -> done[j] = true);
            count++;
        }

        out.println(modPow(2, count, 998244353));
        out.flush();
    }

    private static void dfs(int node, int prev, Set<Integer> set) {
        set.add(node);
        for (final Integer next : g[node]) {
            if (next == prev) continue;
            if (set.contains(next)) continue;
            dfs(next, node, set);
        }
    }

    private static long modPow(long a, long n, int mod) {
        long x = a;
        long res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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