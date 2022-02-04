import java.io.PrintWriter;
import java.util.Scanner;

public class ABC057C {

    public static void main(String[] args) {
        long n = nextLong();
        long ans = String.valueOf(n).length();
        for (long i = 1; i*i <= n; i++) {
            if (n%i==0) {
                ans = Math.min(ans, f(i, n/i));
            }
        }
        out.println(ans);
        out.flush();
    }

    private static int f(long a, long b) {
        return Math.max(
            String.valueOf(a).length(),
            String.valueOf(b).length()
        );
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