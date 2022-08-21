import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ABC204E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Path>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            long c = nextInt();
            long d = nextInt();
            g[a].add(new Path(a, b, c, d));
            g[b].add(new Path(b, a, c, d));
        }
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;
        PriorityQueue<P> pq = new PriorityQueue<>(Comparator.comparing(p -> p.c));
        pq.add(new P(0, 0));
        while (!pq.isEmpty()) {
            P current = pq.poll();
            int ci = current.i;
            long cc = current.c;
            if (cost[ci] != cc) continue;
            for (Path path : g[ci]) {
                double l = cc;
                double r = Long.MAX_VALUE/3;
                while (r-l>2) {
                    double llr = (l+l+r)/3;
                    double lrr = (l+r+r)/3;
                    double llrC = path.c+(path.d/(llr+1))+llr;
                    double lrrC = path.c+(path.d/(lrr+1))+lrr;
                    if (llrC <= lrrC) {
                        r = lrr;
                    } else {
                        l = llr;
                    }
                }
                long nc = LongStream.rangeClosed(Math.max(cc, (long)l-1), (long)r+1)
                    .map(ln -> path.c + (path.d / (ln + 1)) + ln)
                    .min().getAsLong();
                if (cost[path.to] <= nc) continue;
                cost[path.to] = nc;
                pq.add(new P(path.to, nc));
            }
        }

        out.println(cost[n-1] == Long.MAX_VALUE ? -1 : cost[n-1]);
        out.flush();
    }

    private static class P {
        int i;
        long c;
        public P(int i, long c) {
            this.i = i;
            this.c = c;
        }
    }

    private static class Path {
        int from;
        int to;
        long c;
        long d;
        public Path(int from, int to, long c, long d) {
            this.from = from;
            this.to = to;
            this.c = c;
            this.d = d;
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