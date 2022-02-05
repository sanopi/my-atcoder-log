import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC238D {

    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            long a = nextLong();
            long s = nextLong();

            boolean[] isZero = new boolean[61];
            Arrays.fill(isZero, true);
            long aa = a;
            int j = 0;
            while (aa > 0) {
                if (aa % 2 != 0) {
                    isZero[j] = false;
                }
                aa /= 2;
                j++;
            }

            long diff = s-a-a;
            if (diff < 0) {
                out.println("No");
                continue;
            }
            if (diff == 0) {
                out.println("Yes");
                continue;
            }
            for (int k = 60; k >= 0; k--) {
                long l = 1L << k;
                if (isZero[k] && l <= diff) {
                    diff -= l;
                }
                if (diff == 0) {
                    break;
                }
            }
            if (diff == 0) {
                out.println("Yes");
            } else {
                out.println("No");
            }

        }

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