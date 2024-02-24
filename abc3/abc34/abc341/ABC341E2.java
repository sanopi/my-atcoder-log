import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ABC341E2 {

    private static void solve() {

        int n = nextInt();
        int q = nextInt();
        char[] s = next().toCharArray();

        C[] c = new C[n];
        for (int i = 0; i < n; i++) {
            c[i] = new C(true, s[i]-'0', s[i]-'0');
        }

        C cU = new C(true, -1, -1);
        LazySegTree<C, Boolean> lazySegTree = new LazySegTree<>(
            c,
            cU,
            false,
            (c1, c2) -> c1.merge(c2),
            (b1, b2) -> b1 ^ b2,
            (b1, c1) -> c1.invert(b1)
        );

        while (q --> 0) {
            int t = nextInt();
            int l = nextInt()-1;
            int r = nextInt()-1;
            if (t == 1) {
                lazySegTree.applyRange(l, r+1, true);
            } else {
                C result = lazySegTree.query(l, r + 1);
                if (result.good) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
        }

        out.flush();
    }

    private static class C {
        boolean good;
        int left;
        int right;
        public C(boolean good, int left, int right) {
            this.good = good;
            this.left = left;
            this.right = right;
        }
        private C merge(C other) {
            if (other.left < 0) return this;
            if (this.left < 0) return other;
            return new C(
                this.good && other.good && this.right != other.left,
                this.left,
                other.right
            );
        }

        private C invert(boolean todo) {
            if (!todo) return this;
            if (this.left < 0) return this;
            return new C(good, left ^ 1, right ^ 1);
        }
        @Override
        public String toString() {
            return "C{" +
                "good=" + good +
                ", left=" + left +
                ", right=" + right +
                '}';
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


    private static class LazySegTree<T, R> {

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
}
