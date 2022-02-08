import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC094D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Arrays.sort(a);
        int first = a[n-1];
        double point = first/2.0;

        int ok = 0;
        int ng = n;
        while (Math.abs(ok-ng)>1) {
            int p = (ok+ng)/2;
            if (a[p] <= point) {
                ok = p;
            } else {
                ng = p;
            }
        }
        int second;
        if (a[ok]==point) {
            second=(int)point;
        } else {
            if (point - a[ok] > a[ok+1] - point) {
                second = a[ok+1];
            } else {
                second = a[ok];
            }
        }
        out.println(first + " " + second);
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