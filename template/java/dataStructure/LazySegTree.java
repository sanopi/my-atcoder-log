import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

class LazySegTree<T, R> {

    int n;
    int log;
    T[] tree;
    R[] subTree;
    T te;
    R re;
    BinaryOperator<T> op;
    BinaryOperator<R> compose;
    BiFunction<R, T, T> act;


    private LazySegTree(T[] array, T te, R re, BinaryOperator<T> op,BinaryOperator<R> compose, BiFunction<R, T, T> act) {
        this.te = te;
        this.re = re;
        this.op = op;
        this.compose = compose;
        this.act = act;
        int len = array.length;
        n = Integer.highestOneBit(len) << (Integer.bitCount(len)==1 ? 0 : 1);
        log = Integer.numberOfTrailingZeros(n);
        tree =  (T[]) Array.newInstance(te.getClass(), 2 * n);
        Arrays.fill(tree, te);
        for (int i = 0; i < len; i++) tree[i + n] = array[i]; // 葉のindexはnから2n-1まで
        for (int i = n - 1; i >= 1; i--) tree[i] = op.apply(tree[i*2], tree[i*2+1]);
        subTree = (R[]) Array.newInstance(re.getClass(), 2 * n);
        Arrays.fill(subTree, re);
    }

    public void applyRange(int l, int r, R value) {
        l+=n;
        r+=n;
        propagate(l, r);

        int ll = l;
        int rr = r;
        while (ll < rr) {
            // 奇数ノード=右側のノードは上のノードだけを見ても判断できないので、値を反映する。
            if ((ll&1)==1) {
                transmit(ll, value);
                ll++;
            }
            if ((rr&1)==1) {
                transmit(rr-1, value);
                rr--;
            }
            ll >>= 1; rr >>= 1;
        }
        // 最後に、更新したもの=上のノードの情報だけでは判断できないノードに関して、下から順番に、上に反映する。
        for (int i = 1; i <= log; i++) {
            if (((l>>i)<<i) != l) {
                int target = l >> i;
                tree[target] = op.apply(tree[target*2], tree[target*2+1]);
            }
            if (((r>>i)<<i) != r) {
                int target = r >> i;
                tree[target] = op.apply(tree[target*2], tree[target*2+1]);
            }
        }
    }

    public T query(int l, int r) {
        l+=n;
        r+=n;
        propagate(l, r);

        T lResult = te;
        T rResult = te;
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

    private void propagate(int l, int r) {
        for (int i = log; i >= 1; i--) {
            // 部分木の左端である=上のノードの情報だけ見ればいい場合を除き、遅延の伝播が必要。
            if (((l >>i)<<i) != l) propagate(l >>i);
            // rは開区間なので、rが部分木の左端=対象区間は部分木の右端=上のノードの情報だけ見ればいい
            if (((r >>i)<<i) != r) propagate(r >>i);
        }
    }

    private void propagate(int node) {
        transmit(node*2, subTree[node]);
        transmit(node*2+1, subTree[node]);
        subTree[node] = re;
    }

    private void transmit(int node, R value) {
        tree[node] = act.apply(value, tree[node]);
        if (node < n) subTree[node] = compose.apply(subTree[node], value);
    }
}
