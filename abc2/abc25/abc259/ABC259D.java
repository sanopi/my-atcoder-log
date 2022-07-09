import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC259D {

    public static void main(String[] args) {
        int n = nextInt();
        int sx = nextInt();
        int sy = nextInt();
        int tx = nextInt();
        int ty = nextInt();
        Circle[] circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            int r = nextInt();
            circles[i] = new Circle(x, y, r);
        }
        int start=-1;
        for (int i = 0; i < n; i++) {
            if (circles[i].hasPoint(sx, sy)) {
                start = i;
                break;
            }
        }
        int goal=-1;
        for (int i = 0; i < n; i++) {
            if (circles[i].hasPoint(tx, ty)) {
                goal = i;
                break;
            }
        }

        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (circles[i].crosses(circles[j])) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] done = new boolean[n];
        done[start] = true;
        while (!q.isEmpty()) {
            Integer current = q.poll();
            for (Integer next : g[current]) {
                if (done[next]) continue;
                done[next] = true;
                q.add(next);
            }
        }

        out.println(done[goal] ? "Yes" : "No");

        out.flush();
    }

    private static class Circle {
        long x;
        long y;
        long r;
        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
        private boolean hasPoint(long x, long y) {
            long xDiff = Math.abs(this.x - x);
            long yDiff = Math.abs(this.y - y);
            return xDiff * xDiff + yDiff * yDiff == r * r;
        }
        private boolean crosses(Circle other) {
            long xDiff = Math.abs(this.x - other.x);
            long yDiff = Math.abs(this.y - other.y);
            long rDiff = Math.abs(this.r - other.r);
            long rSum = Math.abs(this.r + other.r);
            long dist2 = xDiff * xDiff + yDiff * yDiff;

            return rDiff*rDiff <= dist2 && dist2 <= rSum*rSum;
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