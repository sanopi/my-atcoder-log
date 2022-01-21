import java.io.PrintWriter;
import java.util.Scanner;

public class ABC078C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        // (1800m+100n)*2^m
        int i = m;
        int exp = 1;
        while (i>0) {
            exp *= 2;
            i--;
        }
        out.println((1800*m+100*n)*exp);

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