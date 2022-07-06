import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC191E {

    private static List<Path>[] g;
    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            g[a].add(new Path(a, b, c));
        }

        for (int i = 0; i < n; i++) {
            long[] cost = new long[n];
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[i] = 0;
            PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparing(t -> t.cost));
            pq.add(new Town(i, 0));
            long ans = Integer.MAX_VALUE;
            while (!pq.isEmpty()) {
                Town current = pq.poll();
                int ci = current.i;
                long cc = current.cost;
                if (cost[ci] != cc) continue;
                for (Path path : g[ci]) {
                    long nc = cc + path.cost;
                    if (path.to == i) {
                        ans = Math.min(ans, nc);
                        continue;
                    }
                    if (cost[path.to] <= nc) continue;
                    cost[path.to] = nc;
                    pq.add(new Town(path.to, nc));
                }
            }
            out.println(ans < Integer.MAX_VALUE ? ans : -1);
        }

        out.flush();
    }

    private static class Town {
        int i;
        long cost;
        public Town(int i, long cost) {
            this.i = i;
            this.cost = cost;
        }
    }

    private static class Path {
        int from;
        int to;
        int cost;
        public Path(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
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