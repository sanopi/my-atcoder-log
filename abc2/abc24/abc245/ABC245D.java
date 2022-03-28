import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC245D {

    public static void main(String[] args) {
        int n = nextInt()+1;
        int m = nextInt()+1;
        int[] a = nextIntArray(n);
        int[] c = nextIntArray(n+m-1);

        int[] b = new int[m];
        Arrays.fill(b, Integer.MAX_VALUE);

        for (int i = m-1; i >= 0; i--) {
            int sum = 0;
            for (int j = n - 1; j >= Math.max(0, n-1-(m-1-i)); j--) {
                int k = (n-1-j)+i;
                if (b[k] != Integer.MAX_VALUE) {
                    sum += a[j] * b[k];
                }
            }
            b[i] = (c[n+i-1]-sum)/a[n-1];
        }

        for (int ans : b) {
            out.print(ans +" ");
        }
        out.println();
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