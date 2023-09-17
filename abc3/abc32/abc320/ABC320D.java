import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC320D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        List<B>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int x = nextInt();
            int y = nextInt();
            g[a].add(new B(b, new Pair(x, y)));
            g[b].add(new B(a, new Pair(-x, -y)));
        }

        Pair[] ans = new Pair[n];
        ans[0] = new Pair(0, 0);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer ci = q.poll();
            long cx = ans[ci].x;
            long cy = ans[ci].y;
            for (B to : g[ci]) {
                int ni = to.i;
                if (ans[ni] != null) continue;
                long nx = cx + to.p.x;
                long ny = cy + to.p.y;
                ans[ni] = new Pair(nx, ny);
                q.add(ni);
            }
        }
        for (Pair an : ans) {
            if (an == null) {
                out.println("undecidable");
            } else {
                out.println(an.x + " " + an.y);
            }
        }
        out.flush();
    }

    private static class B {
        int i;
        Pair p;
        public B(int i, Pair p) {
            this.i = i;
            this.p = p;
        }
    }

    private static class Pair {
        long x;
        long y;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
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