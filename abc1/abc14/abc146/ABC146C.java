import java.io.PrintWriter;
import java.util.Scanner;

public class ABC146C {

    public static void main(String[] args) {
        long a = nextInt();
        long b = nextInt();
        long x = nextLong();

        long ok = 0;
        long ng = 1000000001;
        while (Math.abs(ok-ng)>1) {
            long n = (ok+ng)/2;
            if (a*n+b*Long.toString(n).length() <= x) {
                ok=n;
            } else {
                ng = n;
            }
        }
        out.println(ok);
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