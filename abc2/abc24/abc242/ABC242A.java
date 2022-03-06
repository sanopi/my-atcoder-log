import java.io.PrintWriter;
import java.util.Scanner;

public class ABC242A {

    public static void main(String[] args) {
        double a = nextDouble();
        double b = nextDouble();
        double c = nextDouble();
        double x = nextDouble();
        if (x<=a) {
            out.println(1);
        } else if (a<x&& x<=b) {
            out.println(c/(b-a));
        } else {
            out.println(0);
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