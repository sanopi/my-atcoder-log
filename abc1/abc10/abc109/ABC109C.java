import java.io.PrintWriter;
import java.util.Scanner;

public class ABC109C {

    public static void main(String[] args) {
        int n = nextInt();
        int xStart = nextInt();
        long ans = Math.abs(nextInt() - xStart);
        for (int i = 1; i < n; i++) {
            ans = gcd(Math.abs(nextInt() - xStart), ans);
        }
        out.println(ans);

        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
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