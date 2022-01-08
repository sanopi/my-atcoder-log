import java.io.PrintWriter;
import java.util.Scanner;

public class ABC234A {

    public static void main(String[] args) {
        long t = nextLong();
        long ans = f(f(f(t)+t)+f(f(t)));
        out.println(ans);
        out.flush();
    }

    private static long f(long x) {
        return x*x + 2*x + 3;
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