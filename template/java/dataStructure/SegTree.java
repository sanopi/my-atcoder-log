import java.util.Arrays;
import java.util.function.BiFunction;

class SegTree<T> {
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
