import java.io.PrintWriter;
import java.util.Scanner;

public class ABC266B {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        long n = nextLong();
        if (n < 0) {
            long rest = (-n)%MOD;
            out.println((MOD-rest)%MOD);
        } else {
            out.println(n%MOD);
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