import java.io.PrintWriter;
import java.util.Scanner;

public class ABC234B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xdiff = x[i]-x[j];
                int ydiff = y[i]-y[j];
                max = Math.max(max, Math.sqrt(xdiff*xdiff+ydiff*ydiff));
            }
        }
        out.println(max);
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