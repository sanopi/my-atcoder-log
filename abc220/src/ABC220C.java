import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC220C {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        long x = nextLong();

        long sum = Arrays.stream(a).sum();
        long tmp = x / sum;
        long rest = x % sum;
        int i = 0;
        while (rest >= 0) {
            rest -= a[i];
            i++;
        }
        out.println((tmp * n) + i);
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