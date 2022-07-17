import java.io.PrintWriter;
import java.util.Scanner;

public class ABC260C {

    private static int x;
    private static int y;
    public static void main(String[] args) {
        int n = nextInt();
        x = nextInt();
        y = nextInt();
        out.println(red(n));
        out.flush();
    }

    private static long red(int n) {
        if (n == 1) return 0;
        return (x+1)*red(n-1) + x*y*blue(n-1);
    }

    private static long blue(int n) {
        if (n == 1) return 1;
        return red(n-1) + y*blue(n-1);
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