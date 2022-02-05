import java.io.PrintWriter;
import java.util.Scanner;

public class ABC238D {

    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            long a = nextLong();
            long s = nextLong();
            long saa = s - a - a;
            out.println(saa>=0 && (saa &a)==0 ? "Yes" : "No");
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