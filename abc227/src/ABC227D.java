import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC227D {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        long[] a = nextLongArray(n);
        Arrays.sort(a);

        long ok = 0;
        long ng = Long.MAX_VALUE;
        while (Math.abs(ok-ng) > 1) {
            long point = (ok+ng)/2;

            long count = 0;
            long tmp = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] >= point) {
                    count++;
                } else if (tmp + a[i] >= point) {
                    count++;
                    tmp = tmp + a[i] - point;
                } else {
                    tmp += a[i];
                }
            }

            if (count >= k) {
                ok = point;
            } else {
                ng = point;
            }
        }

        out.println(ok);
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