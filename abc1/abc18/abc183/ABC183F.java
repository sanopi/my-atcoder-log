import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC183F {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] c = nextIntArray(n);
        // Map<代表Student, Map<クラス番号, 人数>>
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> classCount = new HashMap<>();
            classCount.put(c[i]-1, 1);
            map.put(i, classCount);
        }

        UnionFind uf = new UnionFind(n);
        while (q-->0) {
            int t = nextInt();
            int a = nextInt()-1;
            int b = nextInt()-1;
            if (t == 1) {
                if (uf.same(a, b)) continue;
                int as = uf.find(a);
                int bs = uf.find(b);

                Map<Integer, Integer> bsMap = map.get(bs);
                Map<Integer, Integer> asMap = map.get(as);
                if (bsMap.size() > asMap.size()) {
                    Map<Integer, Integer> tmp = bsMap;
                    bsMap = asMap;
                    asMap = tmp;
                }
                for (Map.Entry<Integer, Integer> bsEntry : bsMap.entrySet()) {
                    Integer clazz = bsEntry.getKey();
                    Integer count = bsEntry.getValue();

                    asMap.put(clazz, asMap.getOrDefault(clazz, 0)+count);
                }

                uf.unite(a, b);
                as = uf.find(a);
                map.put(as, asMap);
            } else {
                int s = uf.find(a);
                out.println(map.get(s).getOrDefault(b, 0));
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