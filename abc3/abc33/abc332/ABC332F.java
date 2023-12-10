import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ABC332F {

    private static final int MOD = 998244353;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }

        BinaryOperator<Long> op = Math::addExact;
        BinaryOperator<R> compose = (r1, r2) -> r1.compose(r2);
        BiFunction<R, Long, Long> act = (R r, Long l) -> ((1- r.prob+MOD)%MOD * l % MOD + r.value % MOD)%MOD;

        LazySegTree<Long, R> setTree = new LazySegTree<>(
            a,
            0L,
            new R(0, 0),
            op,
            compose,
            act
        );

        for (int i = 0; i < m; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            long x = nextLong();
            long div = modPow(r - l + 1, MOD - 2, MOD);
            setTree.applyRange(l, r+1, new R(div, x*div%MOD));
        }
        for (int i = 0; i < n; i++) {
            out.print(setTree.query(i, i+1) + " ");
        }
        out.println();
        out.flush();
    }

    private static class R {
        long prob;
        long value;
        public R(long prob, long value) {
            this.prob = prob;
            this.value = value;
        }

        private R compose(R other) {
            long otherElse = (1 - other.prob + MOD) % MOD;
            long probA = this.prob * otherElse % MOD;
            return new R(
                (probA + other.prob) % MOD,
                (otherElse*this.value%MOD + other.value%MOD)%MOD
            );
        }
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus ? 1 : 0;
        for (int i = start; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }
        return minus ? -res : res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus ? 1 : 0;
        for (int i = start; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }
        return minus ? -res : res;
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }
}


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


    LazySegTree(T[] array, T te, R re, BinaryOperator<T> op, BinaryOperator<R> compose, BiFunction<R, T, T> act) {
        this.te = te;
        this.re = re;
        this.op = op;
        this.compose = compose;
        this.act = act;
        int len = array.length;
        n = Integer.highestOneBit(len) << (Integer.bitCount(len) == 1 ? 0 : 1);
        log = Integer.numberOfTrailingZeros(n);
        tree = (T[]) Array.newInstance(te.getClass(), 2 * n);
        Arrays.fill(tree, te);
        for (int i = 0; i < len; i++) tree[i + n] = array[i]; // 葉のindexはnから2n-1まで
        for (int i = n - 1; i >= 1; i--) tree[i] = op.apply(tree[i * 2], tree[i * 2 + 1]);
        subTree = (R[]) Array.newInstance(re.getClass(), 2 * n);
        Arrays.fill(subTree, re);
    }

    public void applyRange(int l, int r, R value) {
        l += n;
        r += n;
        propagate(l, r);

        int ll = l;
        int rr = r;
        while (ll < rr) {
            // 奇数ノード=右側のノードは上のノードだけを見ても判断できないので、値を反映する。
            if ((ll & 1) == 1) {
                transmit(ll, value);
                ll++;
            }
            if ((rr & 1) == 1) {
                transmit(rr - 1, value);
                rr--;
            }
            ll >>= 1;
            rr >>= 1;
        }
        // 最後に、更新したもの=上のノードの情報だけでは判断できないノードに関して、下から順番に、上に反映する。
        for (int i = 1; i <= log; i++) {
            if (((l >> i) << i) != l) {
                int target = l >> i;
                tree[target] = op.apply(tree[target * 2], tree[target * 2 + 1]);
            }
            if (((r >> i) << i) != r) {
                int target = r >> i;
                tree[target] = op.apply(tree[target * 2], tree[target * 2 + 1]);
            }
        }
    }

    public T query(int l, int r) {
        l += n;
        r += n;
        propagate(l, r);

        T lResult = te;
        T rResult = te;
        while (l < r) {
            if ((l & 1) == 1) {
                lResult = op.apply(lResult, tree[l]);
                l++;
            }
            if ((r & 1) == 1) {
                rResult = op.apply(tree[r - 1], rResult);
                r--;
            }
            l >>= 1;
            r >>= 1;
        }
        return op.apply(lResult, rResult);
    }

    private void propagate(int l, int r) {
        for (int i = log; i >= 1; i--) {
            // 部分木の左端である=上のノードの情報だけ見ればいい場合を除き、遅延の伝播が必要。
            if (((l >> i) << i) != l) propagate(l >> i);
            // rは開区間なので、rが部分木の左端=対象区間は部分木の右端=上のノードの情報だけ見ればいい
            if (((r >> i) << i) != r) propagate(r >> i);
        }
    }

    private void propagate(int node) {
        transmit(node * 2, subTree[node]);
        transmit(node * 2 + 1, subTree[node]);
        subTree[node] = re;
    }

    private void transmit(int node, R value) {
        tree[node] = act.apply(value, tree[node]);
        if (node < n) subTree[node] = compose.apply(subTree[node], value);
    }
}
