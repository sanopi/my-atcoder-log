import java.io.PrintWriter;
import java.util.Scanner;

public class ABC190F {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        BIT bit = new BIT(n);
        long count = 0;
        for (int i = 0; i < n; i++) {
            bit.add(a[i], 1);
            count += (i+1-bit.sum(a[i]));
        }
        out.println(count);
        for (int i = 0; i < n-1; i++) {
            int ai = a[i];
            int add = (n-1-ai) - (ai);
            count+=add;
            out.println(count);
        }

        out.flush();
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