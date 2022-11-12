import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC277E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        List<Integer>[][] g = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            int a = nextInt();
            g[a][u].add(v);
            g[a][v].add(u);
        }
        boolean[] s = new boolean[n];
        for (int i = 0; i < k; i++) {
            s[nextInt()-1] = true;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(p -> p.cost));
        int[][] costs = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        pq.add(new Point(1, 0, 0));
        costs[1][0] = 0;

        while (!pq.isEmpty()) {
            Point c = pq.poll();
            int ci = c.i;
            int ca = c.a;
            int cc = c.cost;
            if (costs[ca][ci] != cc) continue;
            int nc = cc+1;
            for (Integer ni : g[ca][ci]) {
                if (costs[ca][ni] > nc) {
                    costs[ca][ni] = nc;
                    pq.add(new Point(ca, ni, nc));
                }
            }
            if (s[ci]) {
                int na = 1-ca;
                for (Integer ni : g[na][ci]) {
                    if (costs[na][ni] > nc) {
                        costs[na][ni] = nc;
                        pq.add(new Point(na, ni, nc));
                    }
                }
            }
        }
        int ans = Math.min(costs[0][n-1],costs[1][n-1]);
        out.println(ans == Integer.MAX_VALUE ? -1 : ans);

        out.flush();
    }

    private static class Point {
        int a;
        int i;
        int cost;
        public Point(int a, int i, int cost) {
            this.a = a;
            this.i = i;
            this.cost = cost;
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