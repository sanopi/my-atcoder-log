import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC342E {

    private static final long INF = Long.MAX_VALUE/2;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        List<P>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int l = nextInt();
            int d = nextInt();
            int k = nextInt();
            int c = nextInt();
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[b].add(new P(l, d, k, c, a));
        }
        long[] time = new long[n];
        time[n-1] = INF;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> -node.t));
        pq.add(new Node(n-1, INF));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int ci = current.i;
            long ct = current.t;
            if (time[ci] != ct) continue;
            for (P next : g[ci]) {
                long threshold = ct - next.c;
                if (threshold < next.l) continue;
                long mul = (threshold-next.l)/next.d;
                long nt = next.l + Math.min(mul, next.k - 1) * next.d;
                if (time[next.to] >= nt) continue;
                time[next.to] = nt;
                pq.add(new Node(next.to, nt));
            }
        }

        for (int i = 0; i < n-1; i++) {
            if (time[i] == 0) {
                out.println("Unreachable");
            } else {
                out.println(time[i]);
            }
        }
        out.flush();
    }

    private static class P {
        long l;
        long d;
        long k;
        long c;
        int to;
        public P(long l, long d, long k, long c, int to) {
            this.l = l;
            this.d = d;
            this.k = k;
            this.c = c;
            this.to = to;
        }
    }

    private static class Node {
        int i;
        long t;
        public Node(int i, long t) {
            this.i = i;
            this.t = t;
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