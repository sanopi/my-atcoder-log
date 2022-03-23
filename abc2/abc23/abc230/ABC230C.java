import java.io.PrintWriter;
import java.util.Scanner;

public class ABC230C {

    public static void main(String[] args) {
        long n = nextLong();
        long a = nextLong();
        long b = nextLong();
        long p = nextLong();
        long q = nextLong();
        long r = nextLong();
        long s = nextLong();
        for (long i = p; i <= q; i++) {
            for (long j = r; j <= s; j++) {
                if ((i-a==j-b) && (Math.max(1-a, 1-b) +a <= i && i<=Math.min(n-a, n-b)+a)
                    && (Math.max(1-a, 1-b) +b <= j && j<=Math.min(n-a, n-b)+b)) {
                    out.print("#");
                } else if ((i-a==b-j) && (Math.max(1-a, b-n) +a <= i && i<=Math.min(n-a, b-1)+a)
                    && (b-Math.max(1-a, b-n) >= j && j >= b-Math.min(n-a, b-1))
                ) {
                    out.print("#");
                } else {
                    out.print(".");
                }
            }
            out.println();
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