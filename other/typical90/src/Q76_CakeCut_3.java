import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q76_CakeCut_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        if (sum % 10 != 0) {
            System.out.println("No");
            return;
        }

        int[] b = new int[2*n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            b[i+n] = a[i];
        }

        long[] bb = new long[2*n-1];
        bb[0] = b[0];
        for (int i = 1; i < 2*n-1; i++) {
            bb[i] = bb[i-1] + b[i];
        }

        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(bb, (sum / 10) + bb[i]);
            if (index > 0) {
                System.out.println("Yes");
                return;
            }
        }
        out.println("No");
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}