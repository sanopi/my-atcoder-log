import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;

class SegTree<T> {
    int n;
    T[] tree;
    BiFunction<T, T, T> op;
    T unit;

    SegTree(T[] array, BiFunction<T, T, T> op, T unit) {
        int len = array.length;
        n = Integer.highestOneBit(len) << (Integer.bitCount(len)==1 ? 0 : 1);
        tree =  (T[]) Array.newInstance(unit.getClass(), 2 * n);
        Arrays.fill(tree, unit);
        for (int i = 0; i < len; i++) tree[i + n] = array[i]; // 葉のindexはnから2n-1まで
        for (int i = n - 1; i >= 1; i--) tree[i] = op.apply(tree[i*2], tree[i*2+1]);
        this.op = op;
        this.unit = unit;
    }

    private void updateNode(final int i) {
        tree[i] = op.apply(tree[lChildOf(i)], tree[rChildOf(i)]);
    }

    public void updateValue(int i, T value) {
        int index = i + n;
        tree[index] = value;
        while (index > 0) {
            index = parentOf(index);
            updateNode(index);
        }
    }

    public T query(int l, int r) {
        l+=n;
        r+=n;

        T lResult = unit;
        T rResult = unit;
        while (l < r) {
            if ((l&1)==1) {
                lResult = op.apply(lResult, tree[l]);
                l++;
            }
            if ((r&1)==1) {
                rResult = op.apply(tree[r-1], rResult);
                r--;
            }
            l>>=1;
            r>>=1;
        }
        return op.apply(lResult, rResult);
    }

    private int lChildOf(int i) {
        return i * 2;
    }

    private int rChildOf(int i) {
        return i * 2 + 1;
    }

    private int parentOf(int i) {
        return i / 2;
    }
}
