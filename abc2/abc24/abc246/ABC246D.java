import java.io.PrintWriter;
import java.util.Scanner;

public class ABC246D {

    public static void main(String[] args) {
        long n = nextLong();
        long ans = Long.MAX_VALUE;
        int a = 1000000;
        int b = 0;
        while (a>=b) {
            while (true) {
                long result = calc(a, b);
                if (result >= n) {
                    ans = Math.min(ans, result);
                    break;
                }
                if (result < 0) break;
                b++;
            }
            a--;
        }

        out.println(ans);
        out.flush();
    }

    private static long calc(long a, long b) {
        return a*a*a + a*a*b + a*b*b + b*b*b;
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