import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q13 {

    private static final long INF = Long.MAX_VALUE/3;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        List<Pair>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            long c = nextLong();
            g[a].add(new Pair(b, c));
            g[b].add(new Pair(a, c));
        }

        long[] zero = dijkstra(g, 0);
        long[] enu = dijkstra(g, n-1);
        for (int i = 0; i < n; i++) {
            out.println(zero[i]+enu[i]);
        }

        out.flush();
    }

    private static long[] dijkstra(List<Pair>[] g, int s) {
        Queue<Pair> q = new PriorityQueue<>(Comparator.comparing(pair -> pair.c));
        long[] cost = new long[g.length];
        Arrays.fill(cost, INF);

        q.add(new Pair(s, 0));
        cost[s] = 0;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int ci = current.i;
            long cc = current.c;
            if (cost[ci] != cc) continue;
            for (Pair next : g[ci]) {
                int ni = next.i;
                long nc = cc+next.c;
                if (cost[ni] <= nc) continue;
                cost[ni] = nc;
                q.add(new Pair(ni, nc));
            }
        }
        return cost;
    }

    private static class Pair {
        int i;
        long c;
        public Pair(int i, long c) {
            this.i = i;
            this.c = c;
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