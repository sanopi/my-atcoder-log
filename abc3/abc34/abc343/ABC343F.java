import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ABC343F {

    private static void solve() {
        int n = nextInt();
        int q = nextInt();
        int[] a = nextIntArray(n);
        Inner[] inners = new Inner[n];
        for (int i = 0; i < n; i++) {
            inners[i] = new Inner(a[i]);
        }
        SegTree<Inner> tree = new SegTree<>(
            inners,
            Inner::merge,
            Inner.UNIT
        );

        while (q --> 0) {
            int t = nextInt();
            if (t == 1) {
                int p = nextInt()-1;
                int x = nextInt();
                tree.updateValue(p, new Inner(x));
            } else {
                int l = nextInt()-1;
                int r = nextInt()-1;
                C ans = tree.query(l, r + 1).cc[0];
                out.println(ans.c);
            }
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

    private static class C {
        int a;
        int c;
        public C(int a, int c) {
            this.a = a;
            this.c = c;
        }
        private static C UNIT = new C(0, 0);
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            C c1 = (C) o;
            return a == c1.a && c == c1.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, c);
        }
    }

    private static class Inner {
        C[] cc;
        public Inner(C[] cc) {
            this.cc = cc;
        }

        public Inner(int a) {
            this.cc = new C[2];
            this.cc[0] = C.UNIT;
            this.cc[1] = new C(a, 1);
        }
        private static Inner UNIT = new Inner( new C[] { C.UNIT, C.UNIT } );
        private Inner getSecondLast() {
            int length = cc.length;
            if (length == 2) {
                return this;
            }
            C[] res = new C[2];
            for (int i = length-2; i < length; i++) {
                int j = i + 2 - length;
                res[j] = cc[i];
            }
            return new Inner(res);
        }
        private Inner merge(Inner other) {
            C[] a = this.getSecondLast().cc;
            C[] b = other.getSecondLast().cc;
            List<C> mergedList = new ArrayList<>();
            int ai = 0;
            int bi = 0;
            while (ai < a.length && bi < b.length) {
                if (a[ai].a < b[bi].a) {
                    mergedList.add(a[ai++]);
                } else if (a[ai].a > b[bi].a ){
                    mergedList.add(b[bi++]);
                } else {
                    C aai = a[ai++];
                    C bbi = b[bi++];
                    mergedList.add(new C(aai.a, aai.c+bbi.c));
                }
            }
            for (int i = ai; i < a.length; i++) {
                mergedList.add(a[i]);
            }
            for (int i = bi; i < b.length; i++) {
                mergedList.add(b[i]);
            }
            C[] res = mergedList.toArray(new C[0]);
            return new Inner(res).getSecondLast();
        }
    }

    private static class SegTree<T> {
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
}

