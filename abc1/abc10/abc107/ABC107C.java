import java.io.PrintWriter;
import java.util.Scanner;

public class ABC107C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] x = nextIntArray(n);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n-k; i++) {
            ans = Math.min(ans, Math.abs(x[i])+(x[i+k-1]-x[i]));
        }
        for (int i = n-1; i >= k-1; i--) {
            ans = Math.min(ans, Math.abs(x[i])+(x[i]-x[i-k+1]));
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