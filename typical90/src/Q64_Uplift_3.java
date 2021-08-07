import java.io.PrintWriter;
import java.util.Scanner;

public class Q64_Uplift_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] a = nextIntArray(n);
        long[] b = new long[n-1];
        for (int i = 0; i < n - 1; i++) {
            b[i] = a[i+1] - a[i];
        }
        long e = 0;
        for (int i = 0; i < n-1; i++) { e += Math.abs(b[i]); }

        for (int i = 0; i < q; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            int v = nextInt();
            if (l != 0) {
                long preB = b[l - 1];
                long newB = b[l-1] + v;
                e = e + (Math.abs(newB) - Math.abs(preB));
                b[l-1] = newB;
            }
            if (r != n-1) {
                long preB = b[r];
                long newB = b[r] - v;
                e = e + (Math.abs(newB) - Math.abs(preB));
                b[r] = newB;
            }
            out.println(e);
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}