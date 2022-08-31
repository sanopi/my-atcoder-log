import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC266F {

    private static Set<Integer> closed = new HashSet<>();
    private static List<Integer>[] g;

    public static void main(String[] args) {
        int n = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        Path[] paths = new Path[n];
        for (int i = 0; i < n; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            paths[i] = new Path(u, v);
            g[u].add(v);
            g[v].add(u);
        }
        dfs(0, -1, new boolean[n]);

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            Path path = paths[i];
            if (closed.contains(path.u) && closed.contains(path.v)) {
                continue;
            }
            uf.unite(path.u, path.v);
        }

        int q = nextInt();
        while (q --> 0) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            out.println(uf.isUnited(x, y) ? "Yes" : "No");
        }

        out.flush();
    }


    private static int dfs(int current, int prev, boolean[] done) {
        done[current] = true;
        for (Integer next : g[current]) {
            if (prev == next) continue;
            if (done[next]) {
                closed.add(current);
                return next;
            }

            int result = dfs(next, current, done);
            if (result < 0) continue;
            closed.add(current);
            if (current != result) {
                return result;
            } else {
                return -1;
            }
        }
        return -1;
    }

    private static class Path {
        int u;
        int v;
        public Path(int u, int v) {
            this.u = u;
            this.v = v;
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