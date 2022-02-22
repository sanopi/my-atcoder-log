import java.io.PrintWriter;
import java.util.Scanner;

public class ABC112D {

    public static void main(String[] args) {
        long n = nextInt();
        long m = nextInt();
        long ans = 1;
        for (int i = 1; (long) i *i <= m; i++) {
            if (m%i==0) {
                ans = Math.max(ans, i*n <=m ?i:0);
                ans = Math.max(ans, m/i*n <=m ? m/i :0);
            }
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