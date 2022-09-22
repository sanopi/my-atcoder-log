import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC174F {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] c = nextIntArray(n);

        List<L>[] ls = new List[n];
        for (int i = 0; i < n; i++) {
            ls[i] = new ArrayList<>();
        }
        for (int i = 0; i < q; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            ls[r].add(new L(l, i));
        }

        int[] lastI = new int[n+1];
        Arrays.fill(lastI, -1);

        BIT bit = new BIT(n);
        long[] ans = new long[q];

        for (int i = 0; i < n; i++) {
            int ci = c[i];
            if (lastI[ci] >= 0) {
                bit.add(lastI[ci], -1);
            }
            lastI[ci] = i;
            bit.add(lastI[ci], 1);
            List<L> ll = ls[i];
            for (L l : ll) {
                ans[l.i] = bit.sum(i)-bit.sum(l.l-1);
            }
        }
        for (long an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static class L {
        int l;
        int i;
        public L(int l, int i) {
            this.l = l;
            this.i = i;
        }
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

        private static long calcInvCount(int[] array) {
            int len = array.length;
            int max = Arrays.stream(array).max().getAsInt();
            BIT bit = new BIT(max);
            long count = 0;
            for (int i = 0; i < len; i++) {
                bit.add(array[i], 1);
                count += (i+1-bit.sum(array[i]));
            }
            return count;
        }
    }


}