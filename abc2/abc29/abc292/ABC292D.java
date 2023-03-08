import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC292D {

    private static List<Integer>[] g;
    public static void main(String[] args) {
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

        boolean[] done = new boolean[n];
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (done[i]) continue;
            HashSet<Integer> nodes = new HashSet<>();
            nodes.add(i);
            dfs(i, nodes);
            int edgeCount = 0;
            for (Integer node : nodes) {
                edgeCount += g[node].size();
                done[node] = true;
            }
            if (nodes.size() != edgeCount/2) {
                ok = false;
            }
        }
        out.println(ok ? "Yes" : "No");
        out.flush();
    }

    private static void dfs(int current, Set<Integer> done) {
        for (Integer next : g[current]) {
            if (done.contains(next)) continue;
            done.add(next);
            dfs(next, done);
        }
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