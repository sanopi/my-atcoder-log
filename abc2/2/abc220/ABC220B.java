import java.io.PrintWriter;
import java.util.Scanner;

public class ABC220B {

    public static void main(String[] args) {
        int k = nextInt();
        String a = next();
        String b = next();

        long ai = 0;
        for (final char c : a.toCharArray()) {
            ai *= k;
            ai += (c - '0');
        }


        long bi = 0;
        for (final char c : b.toCharArray()) {
            bi *= k;
            bi += (c - '0');
        }

        out.println(ai * bi);

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