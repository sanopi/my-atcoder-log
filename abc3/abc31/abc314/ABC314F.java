import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class ABC314F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        new Thread(null, () -> extracted(), "", 16 * 1024 * 1024).start();
    }
    private static void extracted() {
        int n = nextInt();
        Node[] tree = new Node[2*n-1];
        for (int i  = 0; i < 2 * n - 1; i++) {
            tree[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            tree[i].size = 1;
        }
        int next = n;
        UnionFind uf = new UnionFind(n);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            int p = nextInt() - 1;
            int q = nextInt() - 1;
            int pp = parent[uf.find(p)];
            int qp = parent[uf.find(q)];
            tree[next].nexts.add(pp);
            tree[next].nexts.add(qp);
            tree[next].size = tree[pp].size + tree[qp].size;
            uf.unite(p, q);
            parent[uf.find(p)] = next;
            parent[uf.find(q)] = next;
            next++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(2*n-2);

        while (!q.isEmpty()) {
            int current = q.poll();
            Node node = tree[current];
            if (node.nexts.size() != 2) continue;
            Node left = tree[node.nexts.get(0)];
            Node right = tree[node.nexts.get(1)];
            long div = modPow(node.size, MOD-2, MOD);
            left.e = (node.e+ left.size%MOD*div%MOD)%MOD;
            right.e = (node.e+right.size%MOD*div%MOD)%MOD;
            q.add(node.nexts.get(0));
            q.add(node.nexts.get(1));
        }
        for (int i = 0; i < n; i++) {
            out.print(tree[i].e + " ");
        }
        out.println();
        out.flush();
    }

    private static class Node {
        long e = 0;
        int size = 0;
        List<Integer> nexts = new ArrayList<>();
        @Override
        public String toString() {
            return "Node{" +
                "e=" + e +
                ", nexts=" + nexts +
                '}';
        }
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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