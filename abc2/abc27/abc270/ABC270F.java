import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ABC270F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] x = nextIntArray(n);
        int[] y = nextIntArray(n);
        Path[] roads = new Path[m];
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            roads[i] = new Path(a, b, c);
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 4; i++) {


            Queue<Path> paths = new PriorityQueue<>(Comparator.comparing(path -> path.c));
            for (int j = 0; j < n; j++) {
                if ((i & 1) != 0) {
                    paths.add(new Path(j, n, x[j]));
                }
                if (((i&2) != 0)) {
                    paths.add(new Path(j, n+1, y[j]));
                }
            }
            for (int j = 0; j < m; j++) {
                paths.add(roads[j]);
            }

            UnionFind uf = new UnionFind(n + 2);
            long result = 0;
            while (!paths.isEmpty()) {
                Path current = paths.poll();
                if (uf.isUnited(current.a, current.b)) continue;
                uf.unite(current.a, current.b);
                result += current.c;
            }
            if (uf.getSize(0) >= n) {
                ans = Math.min(ans, result);
            }
        }

        out.println(ans);
        out.flush();
    }

    private static class Path {
        int a;
        int b;
        int c;
        public Path(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Path{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
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
    private static class UnionFind {
        int[] parents; // 親（根）の情報を持つ
        int[] ranks; // 深さの最大値の情報を持つ（複雑度と同じくらいに考えておく。）
        int[] sizes;

        UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
            sizes = new int[n];
            Arrays.fill(sizes, 1);
        }

        private int find(int x) {
            int parent = parents[x];
            if (x == parent) {
                return x;
            }
            parents[x] = find(parent); // 圧縮（木の繋ぎ直し）
            return parents[x];
        }

        private boolean isUnited(int x, int y) {
            return find(x) == find(y);
        }

        private int getSize(int x) {
            return sizes[find(x)];
        }

        private void unite(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent) {
                return;
            }

            int xRank = ranks[xParent];
            int yRank = ranks[yParent];
            if (xRank < yRank) {
                parents[xParent] = yParent;
                sizes[yParent] += sizes[xParent];
            } else if (yRank < xRank) {
                parents[yParent] = xParent;
                sizes[xParent] += sizes[yParent];
            } else { // xRank == yRank
                parents[xParent] = yParent;
                ranks[xParent]++;
                sizes[yParent] += sizes[xParent];
            }
        }
    }


}