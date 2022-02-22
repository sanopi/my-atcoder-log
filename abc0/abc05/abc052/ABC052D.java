import java.io.PrintWriter;
import java.util.Scanner;

public class ABC052D {

    public static void main(String[] args) {
        int n = nextInt();
        long a = nextLong();
        long b = nextLong();
        int[] x = nextIntArray(n);

        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.min(b, a*(x[i]-x[i-1]));
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