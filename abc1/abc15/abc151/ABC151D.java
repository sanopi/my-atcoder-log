import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC151D {

    private static int h;
    private static int w;
    private static char[][] g;
    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();

        g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i]=next().toCharArray();
        }

        int max = 0;
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (g[x][y] == '.') {
                    max = Math.max(max,getMax(x, y));
                }
            }
        }

        out.println(max);
        out.flush();
    }
    private static int getMax(int x, int y) {
        int max = 0;
        boolean[][] done = new boolean[h][w];
        Queue<S> pq = new ArrayDeque<>();
        S start = new S(x, y, 0);
        start.done(done);
        pq.add(start);
        while (!pq.isEmpty()) {
            S current = pq.poll();
            for (S next : current.nexts(done)) {
                max = Math.max(max, next.count);
                next.done(done);
                pq.add(next);
            }
        }
        return max;
    }

    private static class S {
        private static final int[] nextX = {0, 1, 0, -1};
        private static final int[] nextY = {1, 0, -1, 0};
        int x;
        int y;
        int count;
        private S(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        private List<S> nexts(boolean[][] done) {
            List<S> res = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                S next = new S(x + nextX[i], y + nextY[i], count + 1);
                if (next.isValid() && !next.isDone(done)) {
                    res.add(next);
                }
            }
            return res;
        }

        private boolean isDone(boolean[][] done) {
            return done[x][y];
        }

        private void done(boolean[][] done) {
            done[x][y] = true;
        }

        private boolean isValid() {
            return 0 <= x && x < h && 0 <= y && y < w && g[x][y]=='.';
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