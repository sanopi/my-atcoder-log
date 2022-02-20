import java.io.PrintWriter;
import java.util.Scanner;

public class AGC005A {

    public static void main(String[] args) {
        String x = next();
        int t = 0;
        int max = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == 'T') {
                t++;
            } else {
                t--;
            }
            max = Math.max(max, t);
        }
        out.println(max*2);
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