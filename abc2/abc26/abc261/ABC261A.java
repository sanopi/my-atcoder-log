import java.io.PrintWriter;
import java.util.Scanner;

public class ABC261A {

    public static void main(String[] args) {
        int l1= nextInt();
        int r1= nextInt();
        int l2= nextInt();
        int r2= nextInt();

        if (l1 <= l2) {
            out.println(Math.max(0, Math.min(r1, r2) - l2));
        } else {
            out.println(Math.max(0, Math.min(r1, r2) - l1));
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