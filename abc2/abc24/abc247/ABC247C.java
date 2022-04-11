import java.io.PrintWriter;
import java.util.Scanner;

public class ABC247C {

    public static void main(String[] args) {
        int n = nextInt();
        out.println(solve("1", 1, n));
        out.flush();
    }

    private static String solve(String s, int n, int max) {
        if (n>=max) {
            return s;
        }
        int next = n+1;
        return solve(s+" "+next+" "+s, next, max);
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