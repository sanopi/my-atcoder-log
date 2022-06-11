import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC255D {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] a = nextIntArray(n);
        Arrays.sort(a);
        long[] counts = new long[n];
        long first = 0;
        for (int i = 0; i < n; i++) {
            first += a[i] - a[0];
        }
        counts[0] = first;
        for (int i = 1; i < n; i++) {
            long diff = a[i] - a[i - 1];
            counts[i] = counts[i-1] + diff * ((i-1)-(n-1-i));
        }

        while (q-->0) {
            int x = nextInt();
            int found = Arrays.binarySearch(a, x);
            if (found >= 0) {
                out.println(counts[found]);
                continue;
            }
            found = ~found;
            if (found==0) {
                out.println(counts[0] + (long)(a[0]-x)*n);
            } else if (found>n-1) {
                out.println(counts[n-1] + (long)(x-a[n-1])*n);
            } else {
                long base = counts[found - 1];
                long plus = (long) (x - a[found - 1]) * (found);
                long minus = (long) (x - a[found - 1]) * (n - 1 - found + 1);
                out.println(base + plus - minus);
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