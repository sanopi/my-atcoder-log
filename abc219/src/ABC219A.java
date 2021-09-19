import java.io.PrintWriter;
import java.util.Scanner;

public class ABC219A {

    public static void main(String[] args) {
        int x = nextInt();
        if (x < 40) {
            out.println(40-x);
        } else if (x < 70) {
            out.println(70-x);
        } else if (x < 90) {
            out.println(90-x);
        } else {
            out.println("expert");
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