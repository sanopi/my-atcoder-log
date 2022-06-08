import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ABC202E {

    private static List<Integer>[] tree;
    private static List<Integer>[] depT;
    private static Pair[] times;

    // solve2
    private static List<Q>[] qu;
    private static int[] depCount;
    private static int[] ans;

    public static void main(String[] args) {
        int n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int p = nextInt()-1;
            tree[p].add(i);
        }
        int q = nextInt();

//        solve1(n, q);
        solve2(n, q);
        out.flush();
    }

    private static void solve2(int n, int q) {
        qu = new List[n];
        for (int i = 0; i < n; i++) {
            qu[i] = new ArrayList<>();
        }
        depCount = new int[n];
        ans = new int[q];

        for (int i = 0; i < q; i++) {
            int u = nextInt()-1;
            int d = nextInt();
            qu[u].add(new Q(u, d, i));
        }
        dfs2(0, 0);
        for (int i : ans) {
            out.println(i);
        }
    }

    private static void dfs2(int current, int dep) {
        List<Q> qs = qu[current];
        Map<Integer, Integer> depCountMemo = new HashMap<>();
        for (Q q : qs) {
            depCountMemo.put(q.d, depCount[q.d]);
        }
        depCount[dep]++;
        for (Integer next : tree[current]) {
            dfs2(next, dep+1);
        }
        for (Q q : qs) {
            int d = q.d;
            ans[q.i] = depCount[d] - depCountMemo.get(d);
        }
    }

    private static void solve1(int n, int q) {
        depT = new List[n];
        for (int i = 0; i < n; i++) {
            depT[i] = new ArrayList<>();
        }
        times = new Pair[n];
        for (int i = 0; i < n; i++) {
            depT[i].sort(Comparator.naturalOrder());
        }

        dfs(0, 0, 0);

        for (int i = 0; i < q; i++) {
            int u = nextInt()-1;
            int d = nextInt();
            Pair time = times[u];
            List<Integer> ints = depT[d];
            int f1 = Collections.binarySearch(ints, time.s);
            f1 = f1<0?~f1:f1;
            int f2 = Collections.binarySearch(ints, time.t);
            f2 = f2<0?~f2:f2;
            out.println(f2-f1);
        }
    }

    private static int dfs(int current, int time, int dep) {
        int s = time;
        depT[dep].add(time);
        for (Integer next : tree[current]) {
            time = dfs(next, ++time, dep+1);
        }
        times[current] = new Pair(s, ++time);
        return time;
    }

    private static class Pair {
        int s;
        int t;
        public Pair(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    private static class Q {
        int u;
        int d;
        int i;
        public Q(int u, int d, int i) {
            this.u = u;
            this.d = d;
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

    private static class SegTree<T> {
        int n;
        T[] tree;
        BiFunction<T, T, T> op;
        T unit;

        private SegTree(T[] array, BiFunction<T, T, T> op, T unit) {
            int len = array.length;
            n = getSize(len);
            tree = (T[]) new Object[2 * n - 1];
            this.op = op;
            this.unit = unit;
            initTree(array, len);
        }

        private int getSize(final int len) {
            int exp = 1;
            while (len > exp) {
                exp *= 2;
            }
            return exp;
        }

        private void initTree(final T[] array, final int len) {
            Arrays.fill(tree, unit);
            for (int i = 0; i < len; i++) {
                tree[i + n - 1] = array[i]; // 葉のindexはn-1から2n-2まで
            }
            for (int i = n - 2; i >= 0; i--) {
                updateNode(i);
            }
        }

        private void updateNode(final int i) {
            tree[i] = op.apply(tree[lChildOf(i)], tree[rChildOf(i)]);
        }

        /**
         * 元の配列の値を更新する。
         * 親のnodeに遡っての更新もする。
         *
         * @param i     元の配列のindex
         * @param value 更新後の値
         */
        public void updateValue(int i, T value) {
            int index = i + n - 1;
            tree[index] = value;
            while (index > 0) {
                index = parentOf(index);
                updateNode(index);
            }
        }

        /**
         * 区間の値を求める
         * 実装的には、親から子に下りながら見る。
         *
         *
         * @param l 左端（inclusive）
         * @param r 右端（exclusive）
         */
        public T query(int l, int r) {
            return doQuery(Math.min(l, r), Math.max(l, r), 0, 0, n);
        }

        /**
         * 値の欲しい範囲が、今調べているnodeと被っていなかったらunitを返す。
         * 値の欲しい範囲が広かったら、nodeの値をそのまま返す。
         * 値の欲しい範囲が狭かったら、nodeの子に対して再度このメソッドを実行する。
         *
         * @param l 値の欲しい範囲の左端（inclusive）
         * @param r 値の欲しい範囲の右端（exclusive）
         * @param node 今調べているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        private T doQuery(int l, int r, int node, int lEdge, int rEdge) {
            if (rEdge <= l || r <= lEdge) { return unit; }
            if (l <= lEdge && rEdge <= r) { return tree[node]; }
            return op.apply(
                doQuery(l, r, lChildOf(node), lEdge, (lEdge+rEdge)/2),
                doQuery(l, r, rChildOf(node), (lEdge+rEdge)/2, rEdge)
            );
        }

        private int lChildOf(int i) {
            return i * 2 + 1;
        }

        private int rChildOf(int i) {
            return lChildOf(i) + 1;
        }

        private int parentOf(int i) {
            return (i - 1) / 2;
        }
    }
}