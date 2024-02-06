import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ABC339E {

    private static void solve() {
        int n = nextInt();
        int d = nextInt();
        int[] a = nextIntArray(n);

        Integer[] integers = new Integer[500001];
        Arrays.fill(integers, 0);
        SegTree<Integer> segTree = new SegTree<>(
            integers,
            Math::max,
            0
        );

        for (int i = 0; i < n; i++) {
            int ai = a[i];
            int l = Math.max(0, ai-d);
            int r = Math.min(500000, ai+d);
            int max = segTree.query(l, r + 1);
            segTree.updateValue(ai, max+1);
        }
        Integer ans = segTree.query(0, 500001);
        out.println(ans);
        out.flush();
    }

    private static class P {
        int num;
        int len;
        public P(int num, int len) {
            this.num = num;
            this.len = len;
        }

        private P merge(P other) {
            if (other == null) return this;
            return this.len >= other.len ? this : other;
        }
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
}

class SegTree<T> {
    int n;
    T[] tree;
    BiFunction<T, T, T> op;
    T unit;

    SegTree(T[] array, BiFunction<T, T, T> op, T unit) {
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
     * @param l     値の欲しい範囲の左端（inclusive）
     * @param r     値の欲しい範囲の右端（exclusive）
     * @param node  今調べているnode
     * @param lEdge nodeが表す範囲の左端（inclusive）
     * @param rEdge nodeが表す範囲の右端（exclusive）
     */
    private T doQuery(int l, int r, int node, int lEdge, int rEdge) {
        if (rEdge <= l || r <= lEdge) {
            return unit;
        }
        if (l <= lEdge && rEdge <= r) {
            return tree[node];
        }
        return op.apply(
            doQuery(l, r, lChildOf(node), lEdge, (lEdge + rEdge) / 2),
            doQuery(l, r, rChildOf(node), (lEdge + rEdge) / 2, rEdge)
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
