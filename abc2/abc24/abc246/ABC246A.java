import java.io.PrintWriter;
import java.util.Scanner;

public class ABC246A {

    public static void main(String[] args) {
        int x1 = nextInt();
        int y1 = nextInt();
        int x2 = nextInt();
        int y2 = nextInt();
        int x3 = nextInt();
        int y3 = nextInt();

        int x;
        if (x1 == x2) {
            x = x3;
        } else if (x2 == x3) {
            x = x1;
        } else {
            x = x2;
        }
        int y;
        if (y1 == y2) {
            y = y3;
        } else if (y2 == y3) {
            y = y1;
        } else {
            y = y2;
        }
        out.println(x + " " + y);
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