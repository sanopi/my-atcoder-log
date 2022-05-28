import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC201D {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }
        Queue<Pair> q = new ArrayDeque<>();
        Point[][] points = new Point[h][w];
        points[h-1][w-1] = new Point(0, 0);
        q.add(new Pair(h-1, w-1));
        while(!q.isEmpty()) {
            Pair current = q.poll();
            int cx = current.x;
            int cy = current.y;
            Point cp = points[cx][cy];
            for (Pair next : current.next()) {
                int nx = next.x;
                int ny = next.y;
                if (!(0<= nx && nx <h && 0<= ny && ny <w)) continue;
                if (points[nx][ny] == null) q.add(next);
                int diff = g[cx][cy]=='+'?1:-1;
                if ((nx+ny)%2==0) {
                    Point np = new Point(cp.t + diff, cp.a);
                    points[nx][ny] = np.maxT(points[nx][ny]);
                } else {
                    Point np = new Point(cp.t, cp.a + diff);
                    points[nx][ny] = np.maxA(points[nx][ny]);
                }
            }
        }

        Point result = points[0][0];
        if (result.t-result.a ==0) {
            out.println("Draw");
        } else if (result.t-result.a > 0) {
            out.println("Takahashi");
        } else {
            out.println("Aoki");
        }
        out.flush();
    }

    private static class Pair {
        private static final int[] X = {-1, 0};
        private static final int[] Y = {0, -1};
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private List<Pair> next() {
            return IntStream.range(0, 2)
                .mapToObj(i -> new Pair(this.x + X[i], this.y + Y[i]))
                .collect(Collectors.toList());
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class Point {
        int t;
        int a;
        public Point(int t, int a) {
            this.t = t;
            this.a = a;
        }
        private Point maxT(Point other) {
            if (other == null) return this;
            if ((this.t-this.a) - (other.t-other.a) > 0) {
                return this;
            } else {
                return other;
            }
        }
        private Point maxA(Point other) {
            if (other == null) return this;
            if ((this.a-this.t) - (other.a-other.t) > 0) {
                return this;
            } else {
                return other;
            }
        }
        @Override
        public String toString() {
            return "Point{" +
                "t=" + t +
                ", a=" + a +
                '}';
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