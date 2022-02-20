import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC239F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] d = nextIntArray(n);

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            uf.capacity[i] = d[i];
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            uf.unite(a, b);
            d[a]--;
            d[b]--;
        }
        if (Arrays.stream(d).min().getAsInt()<0) {
            System.out.println(-1);
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            List<Integer> list = map.getOrDefault(parent, new ArrayList<>());
            list.add(i);
            map.put(parent, list);
        }
        List<Map.Entry<Integer, List<Integer>>> entryList = map.entrySet().stream().collect(Collectors.toList());

        int left = 0;
        int lefti = 0;
        int right = 1;
        int righti = 0;
        List<Pair> ans = new ArrayList<>();
        while (right < entryList.size() && left < entryList.size()) {
            if (uf.same(left, righti)) {
                right++;
                continue;
            }
            List<Integer> leftList = entryList.get(left).getValue();
            List<Integer> rightList = entryList.get(right).getValue();
            while (lefti < leftList.size() && d[leftList.get(lefti)] <= 0) {
                lefti++;
            }
            if (lefti == leftList.size()) {
                left++;
                lefti = 0;
                continue;
            }
            while (righti < rightList.size() && d[rightList.get(righti)] <= 0) {
                righti++;
            }
            if (righti == rightList.size()) {
                right++;
                righti = 0;
                continue;
            }
            d[leftList.get(lefti)]--;
            d[rightList.get(righti)]--;
            uf.unite(leftList.get(lefti), rightList.get(righti));
            ans.add(new Pair(leftList.get(lefti), rightList.get(righti)));
        }

        if (Arrays.stream(d).min().getAsInt() != 0 || Arrays.stream(d).max().getAsInt() != 0) {
            System.out.println(-1);
            return;
        }

        for (Pair an : ans) {
            out.println(an.toString());
        }
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return x + " "+ y;
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
        int[] capacity;

        UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
            sizes = new int[n];
            Arrays.fill(sizes, 1);
            capacity = new int[n];
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
        private int capacity(int x) {
            return capacity[find(x)];
        }

        private void unite(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            capacity[xParent]--;
            capacity[yParent]--;
            if (xParent == yParent) {
                return;
            }

            int xRank = ranks[xParent];
            int yRank = ranks[yParent];
            if (xRank < yRank) {
                parents[xParent] = yParent;
                sizes[yParent] += sizes[xParent];
                capacity[yParent] += capacity[xParent];
            } else if (yRank < xRank) {
                parents[yParent] = xParent;
                sizes[xParent] += sizes[yParent];
                capacity[xParent] += capacity[yParent];
            } else { // xRank == yRank
                parents[xParent] = yParent;
                ranks[xParent]++;
                sizes[yParent] += sizes[xParent];
                capacity[yParent] += capacity[xParent];
            }
        }
    }


}