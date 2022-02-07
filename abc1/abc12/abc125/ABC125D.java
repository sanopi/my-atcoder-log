import java.io.PrintWriter;
import java.util.Scanner;

public class ABC125D {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        // i番目で操作を f行った/ g行っていない時の、i+1番目までの合計の最大値
        long[] f = new long[n-1];
        long[] g = new long[n-1];
        f[0] = -a[0] - a[1];
        g[0] = +a[0] + a[1];
        for (int i = 1; i < n - 1; i++) {
            f[i] = Math.max(f[i-1]+2*a[i]-a[i+1], g[i-1]-2*a[i]-a[i+1]);
            g[i] = Math.max(f[i-1]+a[i+1], g[i-1]+a[i+1]);
        }
        out.println(Math.max(f[n-2], g[n-2]));
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