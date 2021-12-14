import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ABC231F {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        a = compress(a);
        b = compress(b);
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(a[i], b[i]);
        }

        Arrays.sort(pairs, Comparator.comparing(p -> p.a));

        var segTree = new SumSegTree(new long[n]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int targetB = pairs[i].b;
            ans += (i+1-segTree.query(0, targetB+1));
            segTree.addValue(targetB, 1);
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int a;
        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
        int b;
        public Pair(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
        }
    }

    private static int[] compress(int[] array) {
        TreeSet<Integer> sortedElements = Arrays.stream(array).boxed().collect(Collectors.toCollection(TreeSet::new));
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int element: sortedElements) map.put(element, count++);
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) res[i] = map.get(array[i]);
        return res;
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


    private static class SumSegTree {

        private static final long UNIT = 0;

        int n;
        long[] tree;
        long[] subTree;

        private SumSegTree(long[] array) {
            int len = array.length;
            n = getSize(len);
            tree = new long[2 * n - 1];
            initTree(array, len);
            subTree = new long[2 * n - 1];
            Arrays.fill(subTree, UNIT);
        }

        private int getSize(final int len) {
            int exp = 1;
            while (len > exp) {
                exp *= 2;
            }
            return exp;
        }

        private void initTree(final long[] array, final int len) {
            Arrays.fill(tree, UNIT);
            for (int i = 0; i < len; i++) {
                tree[i + n - 1] = array[i]; // 葉のindexはn-1から2n-2まで
            }
            for (int i = n - 2; i >= 0; i--) {
                updateNode(i);
            }
        }

        private void updateNode(final int i) {
            tree[i] = tree[lChildOf(i)] + tree[rChildOf(i)];
        }

        /**
         * 元の配列に値を更新する。
         * 親のnodeに遡っての更新もする。
         *
         * @param i     元の配列のindex
         * @param value 更新後の値
         */
        public void updateValue(int i, long value) {
            int index = i + n - 1;
            tree[index] = value;
            while (index > 0) {
                index = parentOf(index);
                updateNode(index);
            }
        }

        /**
         * 元の配列に値を足す。
         * 親のnodeに遡っての更新もする。
         *
         * @param i     元の配列のindex
         * @param value 足す値
         */
        public void addValue(int i, long value) {
            int index = i + n - 1;
            tree[index] += value;
            while (index > 0) {
                index = parentOf(index);
                updateNode(index);
            }
        }

        public void updateRange(int l, int r, long value) {
            doUpdateRange(l, r, value, 0, 0, n);
        }

        /**
         * 値を更新する範囲が、今調べている範囲より広い場合はそのまま更新する
         * 値を更新する範囲が、今調べている範囲と一切被らない場合は何もしない
         * そうでない場合は子に対して再度このメソッドを実行する
         *
         * @param l 更新範囲の左端（inclusive）
         * @param r 更新範囲の右端（exclusive）
         * @param value 更新後の値
         * @param node 今更新しようとしているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        public void doUpdateRange(int l, int r, long value, int node, int lEdge, int rEdge) {
            eval(node); // 以前の範囲更新の結果を先に反映させておく。
            if (rEdge <= l || r <= lEdge) { return; }
            if (l <= lEdge && rEdge <= r) {
                subTree[node] = (r-l) + value;
                eval(node);
                return;
            }
            doUpdateRange(l, r, value, lChildOf(node), lEdge, (lEdge+rEdge)/2);
            doUpdateRange(l, r, value, rChildOf(node), (lEdge+rEdge)/2, rEdge);
            tree[node] = tree[lChildOf(node)] + tree[rChildOf(node)];
        }

        public void addRange(int l, int r, long value) {
            doAddRange(l, r, value, 0, 0, n);
        }

        /**
         * 値を更新する範囲が、今調べている範囲より広い場合はそのまま更新する
         * 値を更新する範囲が、今調べている範囲と一切被らない場合は何もしない
         * そうでない場合は子に対して再度このメソッドを実行する
         *
         * @param l 更新範囲の左端（inclusive）
         * @param r 更新範囲の右端（exclusive）
         * @param value 更新後の値
         * @param node 今更新しようとしているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        public void doAddRange(int l, int r, long value, int node, int lEdge, int rEdge) {
            eval(node); // 以前の範囲更新の結果を先に反映させておく。
            if (rEdge <= l || r <= lEdge) { return; }
            if (l <= lEdge && rEdge <= r) {
                subTree[node] += ((r-l) * value);
                eval(node);
                return;
            }
            doAddRange(l, r, value, lChildOf(node), lEdge, (lEdge+rEdge)/2);
            doAddRange(l, r, value, rChildOf(node), (lEdge+rEdge)/2, rEdge);
            tree[node] = tree[lChildOf(node)] + tree[rChildOf(node)];
        }


        /**
         * 区間の和を求める
         * 実装的には、親から子に下りながら見る。
         *
         *
         * @param l 左端（inclusive）
         * @param r 右端（exclusive）
         */
        public long query(int l, int r) {
            return doQuery(Math.min(l, r), Math.max(l, r), 0, 0, n);
        }

        /**
         * 和の欲しい範囲が、今調べているnodeと被っていなかったらINFを返す。
         * 和の欲しい範囲が広かったら、nodeの値をそのまま返す。
         * 和の欲しい範囲が狭かったら、nodeの子に対して再度このメソッドを実行する。
         *
         * @param l 最小値の欲しい範囲の左端（inclusive）
         * @param r 最小値の欲しい範囲の右端（exclusive）
         * @param node 今調べているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        private long doQuery(int l, int r, int node, int lEdge, int rEdge) {
            eval(node);
            if (rEdge <= l || r <= lEdge) { return UNIT; }
            if (l <= lEdge && rEdge <= r) { return tree[node]; }
            return doQuery(l, r, lChildOf(node), lEdge, (lEdge+rEdge)/2) +
                doQuery(l, r, rChildOf(node), (lEdge+rEdge)/2, rEdge);
        }

        private void eval(int node) {
            if (subTree[node] == UNIT) { return; }
            if (node < n - 1) { // 葉ではない場合
                subTree[lChildOf(node)] += subTree[node]/2;
                subTree[rChildOf(node)] += subTree[node]/2;
            }
            tree[node] += subTree[node];
            subTree[node] = UNIT;
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