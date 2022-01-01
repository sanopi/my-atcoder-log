import java.io.PrintWriter;
import java.util.Scanner;

public class ABC120C {

    public static void main(String[] args) {
        String s = next();
        char[] chars = s.toCharArray();
        int count = 0;
        for (final char c : chars) {
            if (c == '0') {
                count++;
            }
        }
        out.println(Math.min(s.length()-count, count)*2);
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