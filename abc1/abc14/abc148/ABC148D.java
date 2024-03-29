import java.io.PrintWriter;
import java.util.Scanner;

public class ABC148D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int count = 0;
        for (final int i : a) {
            if (i == count+1) {
                count++;
            }
        }
        if (count == 0) {
            out.println(-1);
        } else {
            out.println(n-count);
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