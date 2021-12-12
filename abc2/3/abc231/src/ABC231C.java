import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC231C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] a = nextIntArray(n);
        Arrays.sort(a);
        for (int i = 0; i < q; i++) {
            int x = nextInt();
            if (x <= a[0]) {
                out.println(n);
            } else if (a[n-1] < x) {
                out.println(0);
            } else {
                int ok = n-1;
                int ng = 0;
                while (Math.abs(ok-ng) > 1) {
                    int p = (ok+ng)/2;
                    if (x <= a[p]) {
                        ok = p;
                    } else {
                        ng = p;
                    }
                }
                out.println(n-1 - ng);
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