import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC257D {

    public static void main(String[] args) {
        int n = nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            long x = nextLong();
            long y = nextLong();
            long p = nextLong();
            points[i] = new Point(x, y, p);
        }

        long ok = 10000000000L;
        long ng = 0;

        while (ok - ng > 1) {
            long s = (ok+ng)/2;

            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                Point pi = points[i];
                for (int j = 0; j < n; j++) {
                    if (i==j) continue;
                    Point pj = points[j];
                    if (s*pi.p >= Math.abs(pi.x-pj.x)+Math.abs(pi.y-pj.y)) {
                        g[i].add(j);
                    }
                }
            }

            boolean isOk = false;

            for (int i = 0; i < n; i++) {
                boolean[] done = new boolean[n];
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                done[i] = true;
                while (!q.isEmpty()) {
                    Integer current = q.poll();
                    for (Integer next : g[current]) {
                        if (done[next]) continue;
                        q.add(next);
                        done[next] = true;
                    }
                }
                boolean allOk = true;
                for (int j = 0; j < n; j++) {
                    allOk &= done[j];
                }
                isOk |= allOk;
            }

            if (isOk) {
                ok = s;
            } else {
                ng = s;
            }
        }
        out.println(ok);
        out.flush();
    }

    private static class Point {
        long x;
        long y;
        long p;
        public Point(long x, long y, long p) {
            this.x = x;
            this.y = y;
            this.p = p;
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