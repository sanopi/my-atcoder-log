import java.io.PrintWriter;
import java.util.Scanner;

public class ABC267C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long[] a = nextLongArray(n);

        long current = 0;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            current += a[i]*(i+1);
            sum += a[i];
        }
        long ans = current;
        for (int i = 0; i < n-m; i++) {
            current -= sum;
            current += m*a[i+m];
            sum -= a[i];
            sum += a[i+m];
            ans = Math.max(ans, current);
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