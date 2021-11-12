import java.io.PrintWriter;
import java.util.Scanner;

public class ABC226A {

    public static void main(String[] args) {
        String x = next();
        int index = x.indexOf(".");
        int i = Integer.parseInt(x.substring(0, index));
        int j = Integer.parseInt(x.substring(index+1, index+2));
        if (j >= 5) {
            System.out.println(i+1);
        } else {
            System.out.println(i);
        }
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