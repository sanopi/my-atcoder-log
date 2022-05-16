package again;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q72_LoopRailwayPlan {

    private static int h;
    private static int w;
    private static char[][] grid;
    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '.') {
                    Pair start = new Pair(i, j);
                    ans = Math.max(ans, dfs(start, start, new HashSet<>()));
                }
            }
        }
        out.println(ans<3?-1:ans);
        out.flush();
    }

    private static int dfs(Pair start, Pair current, Set<Pair> done) {
        done.add(current);
        int res = 0;
        for (Pair next : current.nexts()) {
            if (!next.isValid(h, w)) continue;
            if (grid[next.x][next.y] == '#') continue;
            if (next.equals(start)) {
               res = Math.max(res, done.size());
               continue;
            }
            if (done.contains(next)) continue;
            res = Math.max(res, dfs(start, next, done));
        }
        done.remove(current);
        return res;
    }

    private static class Pair {
        private static final int[] X = {1, 0, -1, 0};
        private static final int[] Y = {0, 1, 0, -1};
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private List<Pair> nexts() {
            return IntStream.range(0, 4)
                .mapToObj(i -> new Pair(this.x + X[i], this.y + Y[i]))
                .collect(Collectors.toList());
        }
        private boolean isValid(int h, int w) {
            return 0<=x && x<h && 0<=y && y<w;
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