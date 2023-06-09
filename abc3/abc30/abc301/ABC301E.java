import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC301E {

    private static final int[] X = {1, 0, -1, 0};
    private static final int[] Y = {0, 1, 0, -1};
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int t = nextInt();
        char[][] a = new char[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = next().toCharArray();
        }
        Pair start = null;
        Pair goal = null;
        List<Pair> okashi = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] == 'S') start = new Pair(i, j);
                if (a[i][j] == 'G') goal = new Pair(i, j);
                if (a[i][j] == 'o') okashi.add(new Pair(i, j));
            }
        }
        int n = okashi.size()+2;
        Pair[] points = new Pair[n];
        points[0] = start;
        for (int i = 0; i < okashi.size(); i++) {
            points[i+1] = okashi.get(i);
        }
        points[n-1] = goal;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < n; i++) {
            int[][] d = new int[h][w];
            for (int j = 0; j < h; j++) {
                Arrays.fill(d[j], INF);
            }
            Queue<Pair> q = new ArrayDeque<>();
            Pair pi = points[i];
            q.add(pi);
            d[pi.i][pi.j] = 0;
            while (!q.isEmpty()) {
                Pair current = q.poll();
                int ci = current.i;
                int cj = current.j;
                int cc = d[ci][cj];
                int nc = cc+1;
                for (int j = 0; j < 4; j++) {
                    int ni = ci + X[j];
                    int nj = cj + Y[j];
                    if (ni<0 || h<=ni || nj<0 || w<=nj) continue;
                    if (a[ni][nj] == '#') continue;
                    if (d[ni][nj] <= nc) continue;
                    d[ni][nj] = nc;
                    q.add(new Pair(ni, nj));
                }
            }
            for (int j = 0; j < n; j++) {
                Pair point = points[j];
                dist[i][j] = Math.min(dist[i][j], d[point.i][point.j]);
            }
        }

        int[][] cost = new int[1<<n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(cost[i], INF);
        }
        cost[1][0] = 0;

        for (int i = 0; i < 1 << n; i++) {
            if ((i & 1) == 0) continue;

            // 現在位置
            for (int j = 0; j < n; j++) {
                if ((i&(1<<j)) == 0) continue;
                if (cost[i][j] == INF) continue;
                int cc = cost[i][j];

                // 移動先
                for (int k = 1; k < n; k++) {
                    int ni = i | 1<<k;
                    int nc = cc + dist[j][k];
                    cost[ni][k] = Math.min(cost[ni][k], nc);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < 1 << n; i++) {
            if (cost[i][n-1] <= t) {
                ans = Math.max(ans, Integer.bitCount(i)-2);
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
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