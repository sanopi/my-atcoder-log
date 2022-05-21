import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC252E {

    private static List<Integer> ans = new ArrayList<>();
    private static List<Path>[] g;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            g[a].add(new Path(a, b, c, i));
            g[b].add(new Path(b, a, c, i));
        }

        long[] costs = new long[n];
        Arrays.fill(costs, Long.MAX_VALUE);
        costs[0] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> costs[i]));
        pq.add(0);
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            for (Path path : g[current]) {
                int next = path.to;
                long cost = costs[current] + path.c;
                if (cost < costs[next]) {
                    costs[next] = cost;
                    pq.add(next);
                }
            }
        }
        dfs(0, -1, 0, costs);

        for (Integer an : ans) {
            out.print(an+" ");
        }
        out.println();
        out.flush();
    }

    private static boolean dfs(int current, int prev, long cost, long[] costs) {
        if (costs[current] != cost) return false;
        costs[current] = -1;
        for (Path path : g[current]) {
            int next = path.to;
            boolean res = dfs(next, current, cost + path.c, costs);
            if (res) {
                ans.add(path.i+1);
            }
        }
        return true;
    }

    private static class Path {
        int from;
        int to;
        int c;
        int i;
        public Path(int from, int to, int c, int i) {
            this.from = from;
            this.to = to;
            this.c = c;
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