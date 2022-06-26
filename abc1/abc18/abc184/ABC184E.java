import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC184E {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        List<Pair>[] alpha = new List[26];
        for (int i = 0; i < 26; i++) alpha[i] = new ArrayList<>();

        char[][] grid = new char[h][w];
        Pair s = null;
        Pair g = null;
        for (int i = 0; i < h; i++) {
            char[] chars = next().toCharArray();
            for (int j = 0; j < w; j++) {
                char cj = chars[j];
                grid[i][j] = cj;
                if ('a' <= cj && cj <= 'z') alpha[cj - 'a'].add(new Pair(i, j));
                if (cj == 'S') s = new Pair(i, j);
                if (cj == 'G') g = new Pair(i, j);
            }
        }
        long[][] cost = new long[h][w];
        for (long[] c : cost) Arrays.fill(c, Long.MAX_VALUE);
        cost[s.x][s.y] = 0;
        Queue<Point> pq = new ArrayDeque<>();
        pq.add(new Point(s, 0));
        while (!pq.isEmpty()) {
            Point current = pq.poll();
            long cc = current.c;
            long nc = cc+1;
            Pair cp = current.p;
            int cx = cp.x;
            int cy = cp.y;
            if (cost[cx][cy] != cc) continue;
            ArrayList<Pair> nexts = new ArrayList<>(cp.next());
            if ('a' <= grid[cx][cy] && grid[cx][cy] <= 'z') {
                nexts.addAll(alpha[grid[cx][cy]-'a']);
                alpha[grid[cx][cy]-'a'] = List.of();
            }
            for (Pair next : nexts) {
                int nx = next.x;
                int ny = next.y;
                if (!(0<=nx && nx<h && 0<=ny && ny<w) || grid[nx][ny]=='#') continue;
                if (cost[nx][ny] <= nc) continue;
                cost[nx][ny] = nc;
                pq.add(new Point(next, nc));
            }
        }
        out.println(cost[g.x][g.y] > Integer.MAX_VALUE ? -1 : cost[g.x][g.y]);
        out.flush();
    }

    private static class Pair {
        private static final int[] X = {1, 0, -1, 0};
        private static final int[] Y = {0, -1, 0, 1};
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private List<Pair> next() {
            return IntStream.range(0, 4)
                .mapToObj(i -> new Pair(x + X[i], y + Y[i]))
                .collect(Collectors.toList());
        }
    }

    private static class Point {
        Pair p;
        long c;
        public Point(Pair p, long c) {
            this.p = p;
            this.c = c;
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