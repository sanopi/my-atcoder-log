import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC088D {

    private static final int[] nextX = {1, 0, -1, 0};
    private static final int[] nextY = {0, -1, 0, 1};
    private static int h;
    private static int w;
    private static char[][] s;

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        s = new char[h][w];
        int roadCount = 0;
        for (int i = 0; i < h; i++) {
            s[i] = next().toCharArray();
            for (int j = 0; j < w; j++) {
                if (s[i][j] == '.') {
                    roadCount++;
                }
            }
        }
        int min = getMin();
        out.println(min == -1 ? min : (roadCount - min - 1));

        out.flush();
    }

    private static int getMin() {
        boolean[][] done = new boolean[h][w];
        Queue<Point> q = new ArrayDeque<>();
        done[0][0] =true;
        q.add(new Point(0, 0, 0));
        while (!q.isEmpty()) {
            Point current = q.poll();
            for (Point next : current.nexts()) {
                if (next.x == h-1 && next.y == w-1) return next.count;
                if (done[next.x][next.y]) continue;
                done[next.x][next.y] = true;
                q.add(next);
            }
        }
        return -1;
    }

    private static class Point {
        int x;
        int y;
        int count;
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
        private List<Point> nexts() {
            List<Point> res = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Point next = new Point(x+nextX[i], y+nextY[i], count+1);
                if (next.isValid() && s[next.x][next.y]=='.') {
                    res.add(next);
                }
            }
            return res;
        }
        private boolean isValid() {
            return 0<=x && x<h && 0<=y && y<w;
        }
        @Override
        public String toString() {
            return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", count=" + count +
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