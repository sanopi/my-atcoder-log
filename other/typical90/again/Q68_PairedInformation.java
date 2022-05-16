package again;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q68_PairedInformation {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();

        BIT bit = new BIT(n);
        UnionFind uf = new UnionFind(n);
        while (q --> 0) {
            int t = nextInt();
            int x = nextInt()-1;
            int y = nextInt()-1;
            long v = nextLong();
            if (t==0) {
                if (uf.same(x, y)) continue;
                if (x%2==1) v = -v;
                bit.add(x, v);
                uf.unite(x, y);
            } else {
                if (!uf.same(x, y)) {
                    out.println("Ambiguous");
                    continue;
                }
                long sum = bit.sum(y - 1) - (bit.sum(x - 1));

                if (x%2 == 0) v = -v;
                long ans = v+sum;
                if (y%2 != 1) ans = -ans;
                out.println(ans);
            }
        }
        out.flush();
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

    private static class BIT {
        int n;
        long[] tree;
        BIT(int n) {
            this.n=n;
            tree = new long[n+1];
        }
        private void add(int i, long v) {
            for (int index = i+1; index <= n; index += (index & -index)) {
                tree[index]+=v;
            }
        }
        private long sum(int i) {
            if (i<0) return 0;
            long res = 0;
            for (int index = i+1; index > 0; index -= (index & -index)) {
                res += tree[index];
            }
            return res;
        }
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