import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC256E {

    public static void main(String[] args) {
        int n = nextInt();
        int[] xx = nextIntArray(n);
        int[] cc = nextIntArray(n);
        Branch[] branches = new Branch[n];
        for (int i = 0; i < n; i++) {
            int x = xx[i]-1;
            int c = cc[i];
            branches[i] = new Branch(i, x, c);
        }
        Arrays.sort(branches, Comparator.comparing(b -> -b.c));
        UnionFind uf = new UnionFind(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            Branch branch = branches[i];
            if (!uf.same(branch.a, branch.b)) {
                uf.unite(branch.a, branch.b);
            } else {
                ans += branch.c;
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Branch {
        int a;
        int b;
        int c;
        public Branch(int a, int b, int c) {
            this.a = a;
            this.b = b;
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