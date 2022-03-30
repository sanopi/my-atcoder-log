import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC245F {

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
        }
        Boolean[] ok = new Boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, ok, new HashSet<>());
        }
        int ans = 0;
        for (Boolean b : ok) {
            if (b) ans++;
        }
        out.println(ans);
        out.flush();
    }

    private static boolean dfs(int current, Boolean[] ok, Set<Integer> prev) {
        if (ok[current] != null) return ok[current];
        prev.add(current);
        boolean res = false;
        for (Integer next : g[current]) {
            if (prev.contains(next)) {
                res = true;
                continue;
            }
            res |= dfs(next, ok, prev);
        }
        prev.remove(current);
        ok[current] = res;
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