import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC228D {

    public static void main(String[] args) {
        int n = 1<<20;
        long[] a = new long[n];
        Arrays.fill(a, -1);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(i);
        }

        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            long x = nextLong();
            if (t == 1) {
                int h = (int)(x % n);
                Integer ceiling = ts.ceiling(h);
                if (ceiling == null) {
                    ceiling = ts.ceiling(0);
                }
                ts.remove(ceiling);
                a[ceiling] = x;
            } else {
                out.println(a[(int)(x % n)]);
            }
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

}