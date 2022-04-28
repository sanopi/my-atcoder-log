package again;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q13_Passing {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Path>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            g[a].add(new Path(a, b, c));
            g[b].add(new Path(b, a, c));
        }

        long[] distFrom1 = calcDist(g, 0);
        long[] distFromN = calcDist(g, n-1);
        for (int i = 0; i < n; i++) {
            out.println(distFrom1[i] + distFromN[i]);
        }
        out.flush();
    }

    private static long[] calcDist(List<Path>[] g, int start) {
        long[] dist = new long[g.length];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> dist[i]));
        pq.add(start);
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            for (Path path : g[current]) {
                int next = path.to;
                if (dist[next] > dist[current]+path.cost) {
                    dist[next] = dist[current]+path.cost;
                    pq.add(next);
                }
            }
        }
        return dist;
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