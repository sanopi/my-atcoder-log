import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC340D {

    private static void solve() {
        int n = nextInt();
        List<P>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            long a = nextLong();
            long b = nextLong();
            int x = nextInt()-1;
            g[i].add(new P(i+1, a));
            g[i].add(new P(x, b));
        }
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE/2);
        PriorityQueue<P> pq = new PriorityQueue<>(Comparator.comparing((P p) -> p.cost));
        pq.add(new P(0, 0));
        cost[0] = 0;

        while (!pq.isEmpty()) {
            P current = pq.poll();
            int ci = current.i;
            long cc = current.cost;
            if (cost[ci] != cc) continue;
            for (P p : g[ci]) {
                int ni = p.i;
                long nc = cc+p.cost;
                if (cost[ni] <= nc) continue;
                cost[ni] = nc;
                pq.add(new P(ni, nc));
            }
        }
        out.println(cost[n-1]);
        out.flush();
    }

    private static class P {
        int i;
        long cost;
        public P(int i, long cost) {
            this.i = i;
            this.cost = cost;
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