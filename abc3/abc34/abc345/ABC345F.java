import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ABC345F {

    private static boolean[] twinkles;
    private static boolean[] done;
    private static int count;
    private static Set<Integer> ans;
    private static Set<Edge>[] g;
    private static int k;
    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        k = nextInt();
        if (k %2==1) {
            System.out.println("No");
            return;
        }

        g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(new Edge(v, i));
            g[v].add(new Edge(u, i));
        }
        twinkles = new boolean[n];
        done = new boolean[n];
        count = 0;
        ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!done[i]) {
                dfs(i);
            }
        }

        if (count != k) {
            out.println("No");
        } else {
            out.println("Yes");
            out.println(ans.size());
            for (Integer i : ans) {
                out.print(i+1+" ");
            }
            out.println();
        }

        out.flush();
    }

    private static void dfs(int current) {
        done[current] = true;
        for (Edge edge : g[current]) {
            int next = edge.to;
            if (done[next]) continue;
            dfs(next);
            if (count == k) {
                break;
            }
            if (!twinkles[next]) {
                twinkles[current] = !twinkles[current];
                twinkles[next] = !twinkles[next];
                count += twinkles[current] ? 1 : -1;
                count += twinkles[next] ? 1 : -1;
                ans.add(edge.i);
            }

        }
    }

    private static class Edge {
        int to;
        int i;
        public Edge(int to, int i) {
            this.to = to;
            this.i = i;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return i == edge.i;
        }
        @Override
        public int hashCode() {
            return Objects.hash(i);
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