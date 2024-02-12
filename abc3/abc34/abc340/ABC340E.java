import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC340E {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        long[] a = nextLongArray(n);
        int[] b = nextIntArray(m);

        LazySegTree lazySegTree = new LazySegTree(
            a,
            0L,
            0L
        );
        for (int i = 0; i < m; i++) {
            int bi = b[i];
            Long biCount = lazySegTree.query(bi, bi + 1);
            lazySegTree.applyRange(bi, bi+1, -biCount);


            long cycle = biCount / n;
            long rest = biCount % n;
            lazySegTree.applyRange(0, n, cycle);

            lazySegTree.applyRange(bi+1, (int) Math.min(n, bi+rest+1), 1L);
            if (n < bi+rest+1) {
                lazySegTree.applyRange(0, (int) (bi+rest+1)%n, 1L);
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(lazySegTree.query(i, i+1) + " ");
        }
        out.flush();
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

    private static class LazySegTree {

        int n;
        int log;
        long[] tree;
        long[] subTree;
        long   te;
        long re;

        private LazySegTree(long[] array, long te, long re) {
            this.te = te;
            this.re = re;
            int len = array.length;
            n = Integer.highestOneBit(len) << (Integer.bitCount(len)==1 ? 0 : 1);
            log = Integer.numberOfTrailingZeros(n);
            tree = new long[2*n];
            Arrays.fill(tree, te);
            for (int i = 0; i < len; i++) tree[i + n] = array[i]; // 葉のindexはnから2n-1まで
            for (int i = n - 1; i >= 1; i--) tree[i] = tree[i*2] + tree[i*2+1];
            subTree = new long[2 * n];
            Arrays.fill(subTree, re);
        }

        public void applyRange(int l, int r, long value) {
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
                    tree[target] = tree[target*2] + tree[target*2+1];
                }
                if (((r>>i)<<i) != r) {
                    int target = r >> i;
                    tree[target] = tree[target*2] + tree[target*2+1];
                }
            }
        }

        public long query(int l, int r) {
            l+=n;
            r+=n;
            propagate(l, r);

            long lResult = te;
            long rResult = te;
            while (l < r) {
                if ((l&1)==1) {
                    lResult = lResult + tree[l];
                    l++;
                }
                if ((r&1)==1) {
                    rResult = tree[r-1] + rResult;
                    r--;
                }
                l>>=1;
                r>>=1;
            }
            return lResult + rResult;
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

        private void transmit(int node, long value) {
            tree[node] = value + tree[node];
            if (node < n) subTree[node] = subTree[node] + value;
        }
    }

}

