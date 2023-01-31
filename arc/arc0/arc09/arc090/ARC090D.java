import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ARC090D {

    private static List<Position>[] g;
    private static Long[] dists;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            int d = nextInt();
            g[l].add(new Position(l, r, d));
            g[r].add(new Position(r, l, -d));
        }
        dists = new Long[n];
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (dists[i] == null) {
                ok &= dfs(i, 0);
            }
        }
        out.println(ok?"Yes":"No");
        out.flush();
    }

    private static boolean dfs(int current, long dist) {
        if (dists[current] != null && dists[current] != dist) {
            return false;
        }
        if (dists[current] != null) {
            return true;
        }
        dists[current] = dist;

        boolean res = true;
        for (Position position : g[current]) {
            int next = position.to;
            boolean result = dfs(next, dist + position.dist);
            res &= result;
        }
        return res;
    }

    private static class Position {
        int from;
        int to;
        int dist;
        public Position(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
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