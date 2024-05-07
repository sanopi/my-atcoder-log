import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC351D {

    private static char[][] grid;

    private static final int[] I = {1, 0, -1, 0};
    private static final int[] J = {0, -1, 0, 1};
    private static int h;
    private static int w;

    private static void solve() {
        h = nextInt();
        w = nextInt();
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = next().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] != '.') continue;
                for (int k = 0; k < 4; k++) {
                    int ni = i+ I[k];
                    int nj = j+ J[k];
                    if (!isInside(ni, nj)) continue;
                    if (grid[ni][nj] == '#') {
                        grid[i][j] = 'x';
                        break;
                    }
                }
            }
        }
        UnionFind uf = new UnionFind(h * w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] != '.') continue;
                for (int k = 0; k < 4; k++) {
                    int ni = i+ I[k];
                    int nj = j+ J[k];
                    if (!isInside(ni, nj)) continue;
                    if (grid[ni][nj] == '.') {
                        uf.unite(i*w+j, ni*w+nj);
                    }
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int integer = 0; integer < h * w; integer++) {
            int i = integer/w;
            int j = integer%w;
            if (grid[i][j] != '.') continue;
            List<Integer> list = map.getOrDefault(uf.find(integer), new ArrayList<>());
            list.add(integer);
            map.put(uf.find(integer), list);
        }
        int ans = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Set<Integer> set = new HashSet<>();
            for (Integer integer : entry.getValue()) {
                set.add(integer);
                int i = integer/w;
                int j = integer%w;
                for (int k = 0; k < 4; k++) {
                    int ni = i+ I[k];
                    int nj = j+ J[k];
                    if (!isInside(ni, nj)) continue;
                    if (grid[ni][nj] != '#') {
                        set.add(ni*w+nj);
                    }
                }
            }
            ans = Math.max(ans, set.size());
        }

        out.println(ans);
        out.flush();
    }

    private static boolean isInside(int i, int j) {
        return 0<=i && i<h && 0<=j && j<w;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 128L * 1024 * 1024);
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