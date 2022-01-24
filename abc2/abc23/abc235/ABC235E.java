import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC235E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.c));
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            pq.add(new Node(a, b, c, false, i));
        }
        for (int i = 0; i < q; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            pq.add(new Node(a, b, c, true, i));
        }
        boolean[] ans = new boolean[q];
        UnionFind uf = new UnionFind(n);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.query) {
                if (uf.same(node.a, node.b)) {
                    ans[node.i] = false;
                } else {
                    ans[node.i] = true;
                }
            } else {
                if (!uf.same(node.a, node.b)) {
                    uf.unite(node.a, node.b);
                }
            }
        }
        for (boolean bool : ans) {
            out.println(bool?"Yes":"No");
        }
        out.flush();
    }

    private static class Node {
        int a;
        int b;
        int c;
        boolean query;
        int i;
        public Node(int a, int b, int c, boolean query, int i) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.query = query;
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