import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC287C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        if (m != n-1) {
            System.out.println("No");
            return;
        }
        UnionFind uf = new UnionFind(n);
        int[] count = new int[n];
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            count[u]++;
            count[v]++;
            uf.unite(u,v);
        }
        int[] countcount = new int[n+1];
        for (int i = 0; i < n; i++) {
            countcount[count[i]] ++;
        }
        if (countcount[0] == 0 && countcount[1] == 2 && countcount[2] == n-2 && uf.getSize(0)==n) {
            out.println("Yes");

        } else {
            out.println("No");
        }
        out.flush();
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