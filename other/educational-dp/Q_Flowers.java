import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q_Flowers {

    public static void main(String[] args) {
        int n = nextInt();
        int[] h = nextIntArray(n);
        int[] a = nextIntArray(n);

        MaxSegTree maxSegTree = new MaxSegTree(new long[n]);
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            int hi = h[i]-1;
            long max = maxSegTree.query(0, hi);
            maxSegTree.updateValue(hi, max+ai);
        }
        out.println(maxSegTree.query(0, n));
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

    private static class MaxSegTree {

        private static final long INF = 0;

        int n;
        long[] tree;
        long[] subTree;

        private MaxSegTree(long[] array) {
            int len = array.length;
            n = getSize(len);
            tree = new long[2 * n - 1];
            initTree(array, len);
            subTree = new long[2 * n - 1];
            Arrays.fill(subTree, INF);
        }

        private int getSize(final int len) {
            int exp = 1;
            while (len > exp) {
                exp *= 2;
            }
            return exp;
        }

        private void initTree(final long[] array, final int len) {
            Arrays.fill(tree, INF);
            for (int i = 0; i < len; i++) {
                tree[i + n - 1] = array[i]; // 葉のindexはn-1から2n-2まで
            }
            for (int i = n - 2; i >= 0; i--) {
                updateNode(i);
            }
        }

        private void updateNode(final int i) {
            tree[i] = Math.max(tree[lChildOf(i)], tree[rChildOf(i)]);
        }

        /**
         * 元の配列の値を更新する。
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
                subTree[node] = value;
                eval(node);
                return;
            }
            doUpdateRange(l, r, value, lChildOf(node), lEdge, (lEdge+rEdge)/2);
            doUpdateRange(l, r, value, rChildOf(node), (lEdge+rEdge)/2, rEdge);
            tree[node] = Math.max(tree[lChildOf(node)], tree[rChildOf(node)]);
        }

        /**
         * 区間の最大値を求める
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
         * 最大値の欲しい範囲が、今調べているnodeと被っていなかったらINFを返す。
         * 最大値の欲しい範囲が広かったら、nodeの値をそのまま返す。
         * 最大値の欲しい範囲が狭かったら、nodeの子に対して再度このメソッドを実行する。
         *
         * @param l 最大値の欲しい範囲の左端（inclusive）
         * @param r 最大値の欲しい範囲の右端（exclusive）
         * @param node 今調べているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        private long doQuery(int l, int r, int node, int lEdge, int rEdge) {
            eval(node);
            if (rEdge <= l || r <= lEdge) { return INF; }
            if (l <= lEdge && rEdge <= r) { return tree[node]; }
            return Math.max(
                doQuery(l, r, lChildOf(node), lEdge, (lEdge+rEdge)/2),
                doQuery(l, r, rChildOf(node), (lEdge+rEdge)/2, rEdge)
            );
        }

        private void eval(int node) {
            if (subTree[node] == INF) { return; }
            if (node < n - 1) { // 葉ではない場合
                subTree[lChildOf(node)] = subTree[node];
                subTree[rChildOf(node)] = subTree[node];
            }
            tree[node] = subTree[node];
            subTree[node] = INF;
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