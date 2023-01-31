import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ARC135B {

    public static void main(String[] args) {
        int n = nextInt();
        long[] s = nextLongArray(n);

        long[] a = new long[n+2];

        create(n, s, a);
        calc(n, s, a);
        create(n, s, a);
        calc(n, s, a);
        create(n, s, a);
        calc(n, s, a);
        create(n, s, a);
        if (Arrays.stream(a).min().getAsLong() < 0) {
            out.println("No");
        } else {
            out.println("Yes");
            for (long l : a) {
                out.print(l + " ");
            }
            out.println();
        }
        out.flush();
    }
    private static void calc(int n, long[] s, long[] a) {
        long min = Arrays.stream(a).min().getAsLong();
        if (min < 0) {
            int i=-1;
            for (int j = 0; j < n +2; j++) {
                if (a[j] == min) {
                    i = j;
                }
            }

            a[i] -= min;

            while (i - 3 >= 0) {
                a[i-3] = a[i] - s[i-2] + s[i-3];
                i-=3;
            }
        }
    }

    private static void create(int n, long[] s, long[] a) {
        for (int i = 0; i < n; i++) {
            a[i + 2] = s[i] - a[i] - a[i + 1];
        }
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