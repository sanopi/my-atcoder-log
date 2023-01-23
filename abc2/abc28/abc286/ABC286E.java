import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC286E {

    private static final int MAX = 10000;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        char[][] paths = new char[n][n];
        for (int i = 0; i < n; i++) {
            paths[i] = next().toCharArray();
        }
        Point[][] points = new Point[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(points[i], new Point(MAX, 0L));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (paths[i][j] == 'Y') {
                    points[i][j] = new Point(1, a[j]);
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    points[i][j] = points[i][j].solve(points[i][k].add(points[k][j]));
                }
            }
        }

        int q = nextInt();
        while (q --> 0) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            Point point = points[u][v];
            if (point.cost == MAX) {
                out.println("Impossible");
            } else {
                out.println(point.cost + " " + (point.sum + a[u]));
            }
        }
        out.flush();
    }

    private static class Point {
        final int cost;
        final long sum;
        public Point(int cost, long sum) {
            this.cost = cost;
            this.sum = sum;
        }

        private Point solve(Point other) {
            if (this.cost < other.cost) return this;
            if (other.cost < this.cost) return other;
            if (this.sum < other.sum) return other;
            else return this;
        }

        private Point add(Point other) {
            return new Point(this.cost+ other.cost, this.sum+ other.sum);
        }
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