import java.io.PrintWriter;
import java.util.Scanner;

public class ABC198C {

    public static void main(String[] args) {
        long r = nextInt();
        long x = nextInt();
        long y = nextInt();
        long xx = x*x;
        long yy = y*y;
        long i = 0;
        if (xx+yy < r*r) {
            System.out.println(2);
            return;
        }
        while (true) {
            if (xx + yy <= (r*r) * (i*i)) {
                System.out.println(i);
                break;
            }
            i++;
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