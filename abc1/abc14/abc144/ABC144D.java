import java.io.PrintWriter;
import java.util.Scanner;

public class ABC144D {

    public static void main(String[] args) {
        double a = nextDouble();
        double b = nextDouble();
        double x = nextDouble();
        if (a*a*b/2 < x) {
            x=a*a*b-x;
            System.out.println(Math.toDegrees(Math.atan((2 * x) / a / a / a)));
        } else {
            System.out.println(90-Math.toDegrees(Math.atan((2 * x) / b / b / a)));
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