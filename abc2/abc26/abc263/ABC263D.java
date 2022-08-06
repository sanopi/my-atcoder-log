import java.io.PrintWriter;
import java.util.Scanner;

public class ABC263D {

    public static void main(String[] args) {
        int n = nextInt();
        int l = nextInt();
        int r = nextInt();
        int[] a = nextIntArray(n);

        // i-1までLを選んだ時の、i-1までの総和の最小値
        long[] ll = new long[n+1];
        ll[0] = 0;
        for (int i = 1; i <= n; i++) {
            ll[i] = Math.min(ll[i-1] + a[i-1], (long)l * i);
        }
        long ans = ll[n];
        for (int i = n - 1; i >= 0; i--) {
            ans = Math.min(ans, ll[i]+((long)r*(n-i)));
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