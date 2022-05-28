import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC253F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();
        Q[] qs = new Q[q];

        Integer[] lastUPDQueryIndex = new Integer[n];
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            if (t == 1) {
                int l = nextInt()-1;
                int r = nextInt()-1;
                int x = nextInt();
                qs[i] = new Q1(l, r, x);
            } else if (t == 2) {
                int ii = nextInt()-1;
                int x = nextInt();
                qs[i] = new Q2(ii, x);
                lastUPDQueryIndex[ii] = i;
            } else {
                int ii = nextInt()-1;
                int j = nextInt()-1;
                Q3 q3 = new Q3(ii, j, i);
                qs[i] = q3;
                Integer index = lastUPDQueryIndex[ii];
                if (index != null) {
                    ((Q2)qs[index]).addQ3(q3);
                }
            }
        }

        BIT mx = new BIT(m+1);
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            Q query = qs[i];
            if (query instanceof Q1) {
                Q1 q1 = (Q1) query;
                mx.add(q1.l, q1.x);
                mx.add(q1.r+1, -q1.x);
            } else if (query instanceof Q2) {
                Q2 q2 = (Q2) query;
                for (Q3 q3 : q2.relatedQ3) {
                    ans[q3.index] -= mx.sum(q3.j);
                    ans[q3.index] += q2.x;
                }
            } else {
                Q3 q3 = (Q3) query;
                ans[q3.index] += mx.sum(q3.j);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (qs[i] instanceof Q3) {
                out.println(ans[i]);
            }
        }

        out.flush();
    }

    private static class Pair {
        int x;
        int qi;
        public Pair(int x, int qi) {
            this.x = x;
            this.qi = qi;
        }
    }

    interface Q {}
    private static class Q1 implements Q {
        int l;
        int r;
        int x;
        public Q1(int l, int r, int x) {
            this.l = l;
            this.r = r;
            this.x = x;
        }
    }
    private static class Q2 implements Q {
        int i;
        int x;
        List<Q3> relatedQ3 = new ArrayList<>();
        public Q2(int i, int x) {
            this.i = i;
            this.x = x;
        }
        private void addQ3(Q3 q) { relatedQ3.add(q); }
    }
    private static class Q3 implements Q {
        int i;
        int j;
        int index;
        public Q3(int i, int j, int index) {
            this.i = i;
            this.j = j;
            this.index = index;
        }
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

    private static class BIT {
        int n;
        long[] tree;
        BIT(int n) {
            this.n=n;
            tree = new long[n+1];
        }
        private void add(int i, long v) {
            for (int index = i+1; index <= n; index += (index & -index)) {
                tree[index]+=v;
            }
        }
        private long sum(int i) {
            if (i<0) return 0;
            long res = 0;
            for (int index = i+1; index > 0; index -= (index & -index)) {
                res += tree[index];
            }
            return res;
        }
    }

}