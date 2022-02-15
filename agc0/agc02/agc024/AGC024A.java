import java.io.PrintWriter;
import java.util.Scanner;

public class AGC024A {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long k = nextLong();

        if (k%2 == 0) {
            out.println(a-b);
        } else {
            out.println(-a+b);
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