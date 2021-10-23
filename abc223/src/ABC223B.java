import java.io.PrintWriter;
import java.util.Scanner;

public class ABC223B {

    public static void main(String[] args) {
        String s = next();

        String min = "z".repeat(s.length());
        String max = "a".repeat(s.length());

        for (int i = 0; i < s.length(); i++) {
            s = (s.substring(1) + s.substring(0, 1));
            if (s.compareTo(min) < 0) {
                min = s;
            }
            if (s.compareTo(max) > 0) {
                max = s;
            }
        }
        out.println(min);
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