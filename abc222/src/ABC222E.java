import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ABC222E {

    private static final int MOD = 998244353;

    private static ArrayList<Integer>[] g;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = nextInt()-1;
        }
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

        Map<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < m - 1; i++) {
            List<Pair> path = new ArrayList<>();
            dfs(a[i], a[i + 1], -1, path);
            for (final Pair pair : path) {
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }

        long yes = 0;
        int size = map.size();
        if (size != 0) {
            List<Integer> values = new ArrayList<>(map.values());
            Integer sum = values.stream().reduce(0, Math::addExact);
            if (sum >= Math.abs(k)) {
                int max = 2 * sum + 1;
                int[][] dp = new int[size][max];
                dp[0][sum + values.get(0)] = 1;
                dp[0][sum - values.get(0)] = 1;
                for (int i = 1; i < size; i++) {
                    Integer v = values.get(i);
                    for (int j = 0; j < max; j++) {
                        if (dp[i - 1][j] == 0) {
                            continue;
                        }
                        dp[i][j - v] = (dp[i][j - v] + (dp[i - 1][j])) % MOD;
                        dp[i][j + v] = (dp[i][j + v] + (dp[i - 1][j])) % MOD;
                    }
                }
                yes = dp[size - 1][sum + k];
            }
        }

        int not = n - 1 - size;
        out.println((modPow(2, not, MOD) * yes) % MOD);
        out.flush();
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

    private static boolean dfs(int s, int t, int prev, List<Pair> path) {
        for (final Integer next : g[s]) {
            if (next == prev) {
                continue;
            }
            if (next == t) {
                path.add(new Pair(Math.min(s, t), Math.max(s, t)));
                return true;
            }
            boolean result = dfs(next, t, s, path);
            if (result) {
                path.add(new Pair(Math.min(s, next), Math.max(s, next)));
                return true;
            }
        }
        return false;
    }

    private static class Pair {
        int u;
        @Override
        public String toString() {
            return "Pair{" +
                "u=" + u +
                ", v=" + v +
                '}';
        }
        int v;
        public Pair(final int u, final int v) {
            this.u = u;
            this.v = v;
        }
        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Pair pair = (Pair) o;
            return u == pair.u && v == pair.v;
        }
        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
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