import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC335E {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] point = new int[n];
        point[0] = 1;
        PriorityQueue<P> pq = new PriorityQueue<>(Comparator.comparing((P p) -> a[p.i]).thenComparing(p -> -p.point));
        pq.add(new P(0, 1));
        while (!pq.isEmpty()) {
            P current = pq.poll();
            int ci = current.i;
            int cp = current.point;
            if (point[ci] != cp) continue;
            for (Integer ni : g[ci]) {
                if (a[ci] > a[ni]) continue;
                int np = cp + (a[ci] == a[ni] ? 0 : 1);
                if (point[ni] >= np) continue;
                point[ni] = np;
                pq.add(new P(ni, np));
            }
        }
        out.println(point[n-1]);
        out.flush();
    }

    private static class P {
        int i;
        int point;
        public P(int i, int point) {
            this.i = i;
            this.point = point;
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