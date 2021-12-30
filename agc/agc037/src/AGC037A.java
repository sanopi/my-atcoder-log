import java.io.PrintWriter;
import java.util.Scanner;

public class AGC037A {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = 1;
        String prev = String.valueOf(chars[0]);
        int i = 1;
        for (; i < n-1; i++) {
            if (String.valueOf(chars[i]).equals(prev)) {
                prev = String.valueOf(chars[i]) + String.valueOf(chars[++i]);
            } else {
                prev = String.valueOf(chars[i]);
            }
            count++;
        }
        if (i != n && !prev.equals(String.valueOf(chars[n - 1]))) {
            count++;
        }
        out.println(count);
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