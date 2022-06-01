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
        try {
            for (int i = 0; i < n; i++) {
                if (dists[i] == null) {
                    Pair result = dfs(i, 0);
                    if (result.max - result.min > 1000000000) {
                        throw new Exception();
                    }
                }
            }
            out.println("Yes");
        } catch (Exception e) {
            out.println("No");
        }
        out.flush();
    }

    private static Pair dfs(int current, long dist) throws Exception {
        if (dists[current] != null && dists[current] != dist) {
            throw new Exception();
        }
        if (dists[current] != null) {
            return Pair.of(dists[current]);
        }
        dists[current] = dist;

        Pair res = Pair.UNIT;
        for (Position position : g[current]) {
            int next = position.to;
            Pair result = dfs(next, dist + position.dist);
            res = res.merge(result);
        }
        return res;
    }

    private static class Pair {
        private static final Pair UNIT = new Pair(Long.MAX_VALUE, Long.MIN_VALUE);
        final long min;
        final long max;
        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
        static Pair of(long num) {
            return new Pair(num, num);
        }
        Pair merge(Pair other) {
            return new Pair(Math.min(this.min, other.min), Math.max(this.max, other.max));
        }
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