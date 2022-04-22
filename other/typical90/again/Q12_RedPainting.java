package again;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q12_RedPainting {

    private static final int[] NX = {1, 0, -1, 0};
    private static final int[] NY = {0, -1, 0, 1};

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int q = nextInt();
        boolean[][] red = new boolean[h][w];
        UnionFind uf = new UnionFind(h * w);
        while (q-->0) {
            int query = nextInt();
            if (query == 1) {
                int r = nextInt()-1;
                int c = nextInt()-1;
                red[r][c] = true;
                for (int i = 0; i < 4; i++) {
                    int nr = r + NX[i];
                    int nc = c + NY[i];
                    if (0<=nr && nr<h && 0<=nc && nc<w && red[nr][nc]) {
                        uf.unite(r*w+c, nr*w+nc);
                    }
                }
            } else {
                int ra = nextInt()-1;
                int ca = nextInt()-1;
                int rb = nextInt()-1;
                int cb = nextInt()-1;
                out.println(red[ra][ca]&&red[rb][cb]&&uf.same(ra*w+ca, rb*w+cb) ? "Yes" : "No");
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