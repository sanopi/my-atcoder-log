import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC328F {

    private static void solve() {
        int n = nextInt();
        int q = nextInt();
        UnionFind uf = new UnionFind(n);
        List<Integer> ans = new ArrayList<>();
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(i);
        }
        long[] x = new long[n];

        for (int i = 0; i < q; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            long d = nextLong();
            if (!uf.isUnited(a, b)) {
                int foundA = uf.find(a);
                Set<Integer> aSet = sets[foundA];
                int foundB = uf.find(b);
                Set<Integer> bSet = sets[foundB];
                long actualDiff = x[a] - x[b];
                if (aSet.size() < bSet.size()) {
                    bSet.addAll(aSet);
                    for (Integer integer : aSet) {
                        x[integer] += d - actualDiff;
                    }
                    sets[foundA] = bSet;
                } else {
                    aSet.addAll(bSet);
                    for (Integer integer : bSet) {
                        x[integer] -= d - actualDiff;
                    }
                    sets[foundB] = aSet;
                }
                uf.unite(a, b);
                ans.add(i+1);
            } else {
                if (x[a]-x[b] == d) {
                    ans.add(i+1);
                }
            }
        }

        for (Integer an : ans) {
            out.print(an + " ");
        }
        out.println();
        out.flush();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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