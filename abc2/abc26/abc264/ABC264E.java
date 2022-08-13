import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC264E {

    private static int count;
    private static int n;
    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();
        int e = nextInt();
        Path[] paths = new Path[e];
        for (int i = 0; i < e; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            paths[i] = new Path(u, v, i);
        }

        int q = nextInt();
        int[] events = new int[q];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < q; i++) {
            events[i] = nextInt()-1;
            set.add(events[i]);
        }
        boolean[] ok = new boolean[n +m];
        for (int i = n; i < n +m; i++) {
            ok[i] = true;
        }
        UnionFind uf = new UnionFind(n + m);
        count = 0;
        for (int i = 0; i < e; i++) {
            if (set.contains(i)) continue;
            extracted(ok, uf, paths[i]);
        }
        int[] ans = new int[q];
        ans[q-1] = count;
        for (int i = q - 1; i > 0; i--) {
            Path path = paths[events[i]];
            extracted(ok, uf, path);
            ans[i-1] = count;
        }
        for (int i : ans) {
            out.println(i);
        }
        out.flush();
    }

    private static void extracted(boolean[] ok, UnionFind uf, Path path) {
        int u = path.u;
        int v = path.v;
        if (uf.same(u, v)) return;
        int ui = uf.find(u);
        int vi = uf.find(v);
        boolean uOk = ok[ui];
        boolean vOk = ok[vi];
        if ((uOk && !vOk) && v < n) {
            count += uf.size(v);
        } else if ((!uOk && vOk) && u < n) {
            count += uf.size(u);
        }
        uf.unite(u, v);
        ok[uf.find(u)] = uOk | vOk;
    }

    private static class Path {
        int u;
        int v;
        int i;
        public Path(int u, int v, int i) {
            this.u = u;
            this.v = v;
            this.i = i;
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

        private boolean same(int x, int y) {
            return find(x) == find(y);
        }

        private int size(int x) {
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