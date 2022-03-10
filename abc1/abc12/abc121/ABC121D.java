import java.io.PrintWriter;
import java.util.Scanner;

public class ABC121D {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long ans = 0;
        for (int i = 0; i < 63; i++) {
            long expi = 1L << (i);
            long expi1 = 1L << (i + 1);
            long countA = a/expi1*expi + Math.max(0, a % expi1 - expi);
            long countB = (b+1)/expi1*expi + Math.max(0, (b+1) % expi1 - expi);
            ans += expi * ((countB-countA)%2);
        }
        out.println(ans);
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